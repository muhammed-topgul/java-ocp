package com.mtopgul.concurrency.threadSafeCode.atomicClasses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 16:24
 */
public class SheepManagerAtomic {
    private final AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            SheepManagerAtomic manager = new SheepManagerAtomic();
            for (int i = 0; i < 10; i++) {
                executorService.submit(manager::incrementAndReport);
            }
        } finally {
            executorService.shutdown();
        }
    }
}
