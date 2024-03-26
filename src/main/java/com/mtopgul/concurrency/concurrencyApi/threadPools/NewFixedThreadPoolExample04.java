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
public class NewFixedThreadPoolExample04 {
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

        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);
        Future<String> future4 = executorService.submit(task4);
        Future<String> future5 = executorService.submit(task5);
        Future<String> future6 = executorService.submit(task6);
        Future<String> future7 = executorService.submit(task7);

        System.out.println("Result-1: " + future1.get());
        System.out.println("Result-2: " + future2.get());
        System.out.println("Result-3: " + future3.get());
        System.out.println("Result-4: " + future4.get());
        System.out.println("Result-5: " + future5.get());
        System.out.println("Result-6: " + future6.get());
        System.out.println("Result-7: " + future7.get());

        executorService.shutdown();
    }
}
