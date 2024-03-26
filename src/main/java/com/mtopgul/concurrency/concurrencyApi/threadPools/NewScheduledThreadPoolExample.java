package com.mtopgul.concurrency.concurrencyApi.threadPools;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:39
 */
public class NewScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        Runnable task1 = () -> {
            System.out.println("Executing the task-1, ThreadName: " + Thread.currentThread().getName() + ", " + LocalTime.now());
        };

        Runnable task2 = () -> {
            System.out.println("Executing the task-2, ThreadName: " + Thread.currentThread().getName() + ", " + LocalTime.now());
        };

        Runnable task3 = () -> {
            System.out.println("Executing the task-3, ThreadName: " + Thread.currentThread().getName() + ", " + LocalTime.now());
        };

        service.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(task2, 0, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(task3, 0, 2, TimeUnit.SECONDS);

        System.out.println("Thread main finished");
    }
}
