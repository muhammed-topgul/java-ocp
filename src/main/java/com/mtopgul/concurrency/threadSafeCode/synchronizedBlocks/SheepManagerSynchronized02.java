package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 08:56
 */
public class SheepManagerSynchronized02 {
    private int sheepCount = 0;
    private final Object herd = new Object();

    private void incrementAndReport() {
        synchronized (herd) {
            System.out.print(++sheepCount + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            SheepManagerSynchronized02 manager = new SheepManagerSynchronized02();
            for (int i = 0; i < 10; i++) {
                executorService.submit(manager::incrementAndReport);
            }
        } finally {
            executorService.shutdown();
        }
    }
}
