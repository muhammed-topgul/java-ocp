package com.mtopgul.concurrency.concurrencyApi.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:36
 */
public class AwaitTerminationExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.println("Begin");
            executorService.execute(printInventory);
            executorService.execute(printRecords);
            executorService.execute(printInventory);
            System.out.println("End");
        } finally {
            executorService.shutdown();
        }

        boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
        if (executorService.isTerminated()) {
            System.out.println("Finished!");
        } else {
            System.out.println("At least one task is still running");
        }
    }
}
