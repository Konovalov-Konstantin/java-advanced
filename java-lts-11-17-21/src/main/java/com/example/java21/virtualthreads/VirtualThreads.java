package com.example.java21.virtualthreads;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.sleep;

@Slf4j
public class VirtualThreads {
    public static void main(String[] args) throws Exception {

        /** Виртуальные потоки в отличие от обычных потоков операционной системы, являются легковесными и могут
            создаваться в огромном количестве.
        */
        final ThreadFactory factory = Thread.ofVirtual().name("routine-", 0).factory();

        try (var executor = Executors.newThreadPerTaskExecutor(factory)) {  // создается новый виртуальный поток для каждой задачи
            var bathTime =
                    executor.submit(
                            () -> {
                                log.info("I'm going to take a bath");
                                try {
                                    sleep(Duration.ofMillis(500L));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                log.info("I'm done with the bath");
                            });
            var boilingWater =
                    executor.submit(
                            () -> {
                                log.info("I'm going to boil some water");
                                try {
                                    sleep(Duration.ofSeconds(1L));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                log.info("I'm done with the water");
                            });
            bathTime.get();
            boilingWater.get();
        }
    }
}
