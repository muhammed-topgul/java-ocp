package com.mtopgul.concurrency.concurrencyApi.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:27
 */
public class CallableCancelExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callableMessage = () -> {
            Thread.sleep(1000);
            return "Callable message";
        };

        Future<String> stringFuture = executorService.submit(callableMessage);
        int count = 0;
        while (!stringFuture.isDone()) {
            System.out.println("Task still not done...");
            Thread.sleep(200);
            count++;
            if (count > 4) {
                System.out.println("Cancelling");
                stringFuture.cancel(true);
            }
        }

        if (!stringFuture.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            String result = stringFuture.get();
            System.out.println("Result: " + result);
        } else {
            System.out.println("Task was cancelled");
        }
        executorService.shutdown();
    }
}
