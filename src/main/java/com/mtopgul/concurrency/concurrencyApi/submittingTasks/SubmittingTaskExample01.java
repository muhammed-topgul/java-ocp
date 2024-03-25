package com.mtopgul.concurrency.concurrencyApi.submittingTasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 20:15
 */
public class SubmittingTaskExample01 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Hello-Message-Task");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            executorService.execute(task);
            executorService.submit(task);
            executorService.submit(new MyRunnable());
        } finally {
            executorService.shutdown();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }
}
