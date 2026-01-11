/*
 *  Copyright 2021-present the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.java17.switchexpressions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.util.Random;

public class SwitchExpressionsExamples {

    private static final Logger logger = LoggerFactory.getLogger(SwitchExpressionsExamples.class);

    public static void switchOnEnum() {

        final var dayOfWeek = DayOfWeek.of(new Random().nextInt(1, 7));

        // до java 17
        int numberOfLetters1;
        switch (dayOfWeek) {
            // Handling multiple constants in same way can be done but requires repeating the 'case' label -
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numberOfLetters1 = 6;
                break; // By default logic falls through to next case block, so breaks are typically needed
            case TUESDAY:
                numberOfLetters1 = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numberOfLetters1 = 8;
                break;
            case WEDNESDAY:
                numberOfLetters1 = 9;
                break;
            // Optional default statement, typically needed to check for unhandled cases.
            default:
                throw new IllegalStateException("Logic error. Unknown day of week [" + dayOfWeek + "].");
        }

        /** c 17-й java - switch expression
            результат работы switch можно сохранить в переменную
         */
        final int numberOfLetters2 = switch (dayOfWeek) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            // новый синтаксис '->' для возврата результата, break не нужен
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            /** если case блок содержит какую-то логику, используется yield для возврата результата */
            case WEDNESDAY -> {
                System.out.println("какая-то логика");
                yield 9;
            }
            default -> 0;
        };

    }

    public static void caseBlockWithYield() {
        final var phonetics = new String[]{"alfa", "bravo", "charlie", "delta", "echo", "foxtrot"};
        final var phonetic = phonetics[new Random().nextInt(0, phonetics.length - 1)];

        int phoneticLength = switch (phonetic) {
            /** если case блок содержит какую-то логику, используется yield для возврата результата */
            case "alfa" -> {
                System.out.println("Matched alfa");
                yield 4;
            }
            case "bravo" -> 5;

            default -> {
                System.out.println("Matched phonetic [" + phonetic + "]");
                yield phonetic.length();
            }

        };
        System.out.println("RESULT: " + phoneticLength);
    }

    public static void main(String[] args) {
        caseBlockWithYield();
    }
}