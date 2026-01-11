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
package com.example.java17.sealedclasses;

public class SealedClassesExamples {

    /**
     В этом sealed-классе нужно сразу объявить (permits) список классов-наследников, потому что кроме них наследников быть не может
     */
    abstract sealed class Shape permits Circle, Rectangle, Square {
    }

    // класс Circle может унаследоваться от Shape, т.к. у класса Shape в permits указан класс Circle
    final class Circle extends Shape {
    }

    sealed class Rectangle extends Shape permits TransparentRectangle, FilledRectangle {
    }

    /** non-sealed снимает любые ограничения по наследованию */
    non-sealed class Square extends Shape {
    }

//      данный класс не может наследоваться от Shape т.к. он не прописан в permits у класса Shape
//    class FilledSquare extends Shape { }

    final class TransparentRectangle extends Rectangle {
    }

    final class FilledRectangle extends Rectangle {
    }
}