package com.mtopgul.concurrency.concurrencyApi.submittingTasks;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 20:22
 */
public class SubmittingTaskExample03 {
    public static void main(String[] args) {
        Callable<Integer> task1 = () -> 100;
        Callable<Integer> task2 = () -> 200;
        Callable<Integer> task3 = () -> 300;
        Callable<Integer> task4 = () -> 400;

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            Integer anyResult = executorService.invokeAny(List.of(task1, task2, task3, task4));
            System.out.println("Any result: " + anyResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
