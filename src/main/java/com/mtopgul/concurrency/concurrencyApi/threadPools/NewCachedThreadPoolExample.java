package com.mtopgul.concurrency.concurrencyApi.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:43
 */
public class NewCachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Runnable task = () -> System.out.println("Task1, " + Thread.currentThread().getName());

        for (int i = 0; i < 1_000; i++) {
            service.submit(task);
        }

        service.shutdown();
    }
}
