package com.mtopgul.concurrency.threadSafeCode.understanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 15:42
 */
public class CounterExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();
        for (int i = 0; i < 1_000; i++) {
            executorService.submit(counter::execute);
        }
        executorService.shutdown();

        boolean finished = executorService.awaitTermination(5, TimeUnit.SECONDS);
        if (finished) {
            System.out.println(counter.getValue());
        }
    }
}
