package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 08:42
 */
public class SheepManagerGoodSynchronized {
    private int sheepCount = 0;
    private int repetitionCount = 0;
    private final Set<Integer> set = new HashSet<>();

    private void incrementAndReport() {
        synchronized (this) {
            ++sheepCount;
            boolean alreadyExist = !set.add(sheepCount);
            if (alreadyExist) {
                System.out.printf("%d* \n", sheepCount);
                repetitionCount++;
            }
        }
    }

    private void printTotalRepetitiveCount() {
        System.out.println("Total repetition: " + repetitionCount);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SheepManagerGoodSynchronized manager = new SheepManagerGoodSynchronized();
        long started = 0, ended = 0;
        try {
            started = System.currentTimeMillis();
            for (int i = 0; i < 1_000_000; i++) {
                executorService.submit(manager::incrementAndReport);
            }
        } finally {
            executorService.shutdown();
            boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (finished) {
                manager.printTotalRepetitiveCount();
                ended = System.currentTimeMillis();
                System.out.printf("Time diff: %d ms", (ended - started));
            }
        }
    }
}
