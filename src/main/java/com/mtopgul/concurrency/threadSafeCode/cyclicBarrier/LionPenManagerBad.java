package com.mtopgul.concurrency.threadSafeCode.cyclicBarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 13:33
 */
public class LionPenManagerBad {
    private void removeLions() {
        System.out.printf("(-) Removing lions by '%s'.\n", Thread.currentThread().getName());
    }

    private void cleanPen() {
        System.out.printf("(#) Cleaning the pen by '%s'.\n", Thread.currentThread().getName());
    }

    private void addLions() {
        System.out.printf("(+) Adding lions by '%s'.\n", Thread.currentThread().getName());
    }

    public void performTask() {
        removeLions();
        cleanPen();
        addLions();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            LionPenManagerBad manager = new LionPenManagerBad();
            for (int i = 0; i < 4; i++) {
                executorService.submit(manager::performTask);
            }
        } finally {
            executorService.shutdown();
        }
    }
}
