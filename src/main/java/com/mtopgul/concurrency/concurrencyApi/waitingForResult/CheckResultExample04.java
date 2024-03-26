package com.mtopgul.concurrency.concurrencyApi.waitingForResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:02
 */
public class CheckResultExample04 {
    private static int counter = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> future = executorService.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
                Thread.sleep(1000);
                return counter;
            });
            Integer futureReference = future.get();
            System.out.println("Reached!: " + counter);
            System.out.println("Future value: " + futureReference);
        } finally {
            executorService.shutdown();
        }
    }
}
