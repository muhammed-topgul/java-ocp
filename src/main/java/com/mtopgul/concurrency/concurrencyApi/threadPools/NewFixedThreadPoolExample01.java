package com.mtopgul.concurrency.concurrencyApi.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:23
 */
public class NewFixedThreadPoolExample01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> System.out.println("Task-1, ThreadName: " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task-2, ThreadName: " + Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println("Task-3, ThreadName: " + Thread.currentThread().getName());
        Runnable task4 = () -> System.out.println("Task-4, ThreadName: " + Thread.currentThread().getName());
        Runnable task5 = () -> System.out.println("Task-5, ThreadName: " + Thread.currentThread().getName());
        Runnable task6 = () -> System.out.println("Task-6, ThreadName: " + Thread.currentThread().getName());
        Runnable task7 = () -> System.out.println("Task-7, ThreadName: " + Thread.currentThread().getName());

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.execute(task5);
        executorService.execute(task6);
        executorService.execute(task7);

        executorService.shutdown();
    }
}
