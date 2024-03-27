package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:13
 */
public class CollectorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        CollectorV1 collectorV1 = new CollectorV1();

        for (int i = 0; i < 100_000; i++) {
            executorService.submit(() -> collectorV1.addV1(10));
            executorService.submit(() -> collectorV1.addV2(10));

            executorService.submit(() -> CollectorV2.addV1(10));
            executorService.submit(() -> CollectorV2.addV2(10));
        }

        executorService.shutdown();
        boolean terminated = executorService.awaitTermination(5, TimeUnit.SECONDS);

        if (terminated) {
            System.out.println("Sum1: " + collectorV1.getSum());
            System.out.println("Sum2: " + CollectorV2.getSum());
        }
    }
}
