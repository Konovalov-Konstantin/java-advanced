package com.otus.java.advanced.instrumentation.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SomeService {
    private static final Logger log = LoggerFactory.getLogger(SomeService.class);

    public void process(int data) throws InterruptedException {
        /** закомментированный код вынесен в PerformanceTransformer */
//        long startTime = System.nanoTime();
        TimeUnit.SECONDS.sleep(2);
        log.info("Successful operation: {}", data);
//        long endTime = System.nanoTime();
//        long opTime = startTime - endTime / (long) 1000;
//        log.info("[My log] operation completed in {} ms", opTime);
    }
}
