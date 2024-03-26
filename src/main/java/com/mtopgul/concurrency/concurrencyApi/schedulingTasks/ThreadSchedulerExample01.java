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
 * @since 26/03/2024 09:26
 */
public class ThreadSchedulerExample01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        System.out.printf("Started at %s\n", LocalTime.now());
        Runnable task1 = () -> System.out.printf("Hello Zoo at %s\n", LocalTime.now());

        Callable<String> task2 = () -> "Monkey at %s\n".formatted(LocalTime.now());

        ScheduledFuture<?> scheduled1 = service.schedule(task1, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduled2 = service.schedule(task2, 6, TimeUnit.SECONDS);

        System.out.println(scheduled1.get());
        System.out.println(scheduled2.get());

        service.shutdown();
    }
}
