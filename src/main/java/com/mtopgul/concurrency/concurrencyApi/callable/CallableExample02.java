package com.mtopgul.concurrency.concurrencyApi.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:19
 */
public class CallableExample02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = null;
        try {
            future = executorService.submit(() -> {
                Thread.sleep(2000);
                return 10;
            });
            System.out.println("Result: " + future.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Is done: " + future.isDone());
            System.out.println("Is cancelled: " + future.isCancelled());
        } finally {
            executorService.shutdown();
        }
    }
}
