package com.mtopgul.concurrency.threadSafeCode.understanding;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:49
 */
public class SheepManager {
    private int sheepCount = 0;
    private final Set<Integer> set = new HashSet<>();

    private void incrementAndReport() {
        ++sheepCount;
        boolean alreadyExist = !set.add(sheepCount);
        if (alreadyExist) {
            System.out.printf("%d* ", sheepCount);
        } else {
           // System.out.print(sheepCount + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 1_000; i++) {
                executorService.submit(manager::incrementAndReport);
            }
        } finally {
            executorService.shutdown();
        }
    }
}
