package com.mtopgul.concurrency.concurrencyApi.submittingTasks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 20:18
 */
public class SubmittingTaskExample02 {
    public static void main(String[] args) {
        Callable<Integer> task1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10_000; i++) {
                sum += i;
            }
            return sum;
        };
        Callable<Integer> task2 = () -> new Random().nextInt();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            List<Future<Integer>> futures = executorService.invokeAll(List.of(task1, task2));
            for (Future<Integer> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
