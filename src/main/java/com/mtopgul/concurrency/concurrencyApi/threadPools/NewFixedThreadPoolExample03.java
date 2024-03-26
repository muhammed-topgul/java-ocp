package com.mtopgul.concurrency.concurrencyApi.threadPools;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:28
 */
public class NewFixedThreadPoolExample03 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            System.out.println("Task-1, ThreadName: " + Thread.currentThread().getName());
            return "task1#done";
        };

        Callable<String> task2 = () -> {
            System.out.println("Task-2, ThreadName: " + Thread.currentThread().getName());
            return "task2#done";
        };

        Callable<String> task3 = () -> {
            System.out.println("Task-3, ThreadName: " + Thread.currentThread().getName());
            return "task3#done";
        };

        Callable<String> task4 = () -> {
            System.out.println("Task-4, ThreadName: " + Thread.currentThread().getName());
            return "task4#done";
        };

        Callable<String> task5 = () -> {
            System.out.println("Task-5, ThreadName: " + Thread.currentThread().getName());
            return "task5#done";
        };

        Callable<String> task6 = () -> {
            System.out.println("Task-6, ThreadName: " + Thread.currentThread().getName());
            return "task6#done";
        };

        Callable<String> task7 = () -> {
            System.out.println("Task-7, ThreadName: " + Thread.currentThread().getName());
            return "task7#done";
        };

        List<Callable<String>> tasks = List.of(task1, task2, task3, task4, task5, task6, task7);

        String any = executorService.invokeAny(tasks);
        System.out.println("Results: " + any);

        executorService.shutdown();
    }
}
