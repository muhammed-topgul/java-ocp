package com.mtopgul.concurrency.concurrencyApi.waitingForResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:02
 */
public class CheckResultExample02 {
    private static int counter = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> future = executorService.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
                return counter;
            });
            Object futureReference = future.get(100, TimeUnit.MILLISECONDS);
            System.out.println("Reached!: " + counter);
            System.out.println("Future value: " + futureReference);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            executorService.shutdown();
        }
    }
}
