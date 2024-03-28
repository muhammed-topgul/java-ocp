package com.mtopgul.concurrency.threadSafeCode.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 14:06
 */
public class LionPenManagerGood {
    private void removeLions() {
        System.out.printf("(-) Removing lions by '%s'.\n", Thread.currentThread().getName());
    }

    private void cleanPen() {
        System.out.printf("(#) Cleaning the pen by '%s'.\n", Thread.currentThread().getName());
    }

    private void addLions() {
        System.out.printf("(+) Adding lions by '%s'.\n", Thread.currentThread().getName());
    }

    public void performTask(CyclicBarrier cyclicBarrier) {
        try {
            removeLions();
            cyclicBarrier.await();

            cleanPen();
            cyclicBarrier.await();

            addLions();
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            LionPenManagerGood manager = new LionPenManagerGood();
            CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("*** Operation completed ***\n"));

            for (int i = 0; i < 4; i++) {
                executorService.submit(() -> manager.performTask(cyclicBarrier));
            }
        } finally {
            executorService.shutdown();
        }
    }
}
