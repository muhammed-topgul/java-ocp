package com.mtopgul.concurrency.concurrencyApi.schedulingTasks;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 09:32
 */
public class ThreadSchedulerExample03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Callable<String> task = () -> {
            LocalTime now = LocalTime.now();
            System.out.println("Task time: " + now);
            return "Hello message!";
        };
        LocalTime now = LocalTime.now();
        System.out.println("Before schedule: " + now);
        ScheduledFuture<?> scheduled = service.schedule(task, 5, TimeUnit.SECONDS);

        System.out.println(scheduled.get());

        service.shutdown();
    }
}
