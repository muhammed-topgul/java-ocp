package com.mtopgul.concurrency.threadSafeCode.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 14:20
 */
public class CyclicBarrierExample01 {
    private record Task(CyclicBarrier cyclicBarrier) implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier.");
                cyclicBarrier.await(1, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
            } catch (BrokenBarrierException | InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("### Operation completed. ###\n"));
        Thread thread1 = new Thread(new Task(cyclicBarrier), "[Thread-1]");
        Thread thread2 = new Thread(new Task(cyclicBarrier), "[Thread-2]");
        Thread thread3 = new Thread(new Task(cyclicBarrier), "[Thread-3]");
        Thread thread4 = new Thread(new Task(cyclicBarrier), "[Thread-4]");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
