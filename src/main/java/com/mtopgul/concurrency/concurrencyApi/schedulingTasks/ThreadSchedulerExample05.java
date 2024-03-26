package com.mtopgul.concurrency.concurrencyApi.schedulingTasks;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 09:38
 */
public class ThreadSchedulerExample05 {
    private static int counter = 0;

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task = () -> {
            LocalTime now = LocalTime.now();
            System.out.println("Task time: " + now);
            System.out.println("Counter: " + ++counter);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        LocalTime now = LocalTime.now();
        System.out.println("Before schedule: " + now);

        service.scheduleAtFixedRate(task, 2, 6, TimeUnit.SECONDS);
    }
}
