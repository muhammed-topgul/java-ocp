package com.mtopgul.concurrency.threadSafeCode.understanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:57
 */
public class CollectorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Collector collector = new Collector();

        for (int i = 0; i < 1_000; i++) {
            executorService.submit(() -> collector.add(10));
        }

        executorService.shutdown();

        boolean awaitTermination = executorService.awaitTermination(5, TimeUnit.SECONDS);

        if (awaitTermination) {
            System.out.println(collector.getSum());
        }
    }
}
