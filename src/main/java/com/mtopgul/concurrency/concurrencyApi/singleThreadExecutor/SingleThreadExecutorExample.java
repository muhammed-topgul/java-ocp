package com.mtopgul.concurrency.concurrencyApi.singleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 19:58
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        Runnable printInventory = () -> System.out.printf("(%s) Printing zoo inventory\n", Thread.currentThread().getName());
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.printf("(%s) Printing record: %d\n", Thread.currentThread().getName(), i);
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.printf("(%s) Begin\n", Thread.currentThread().getName());
            executorService.execute(printInventory);
            executorService.execute(printRecords);
            executorService.execute(printInventory);
            System.out.printf("(%s) End\n", Thread.currentThread().getName());
        } finally {
            executorService.shutdown();
        }
    }
}
