package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 13:00
 */
public class ReentrantLockTryLockExample02 {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(ReentrantLockTryLockExample02::tryLockMethod);
        executorService.submit(ReentrantLockTryLockExample02::tryLockMethod);

        executorService.shutdown();
    }

    private static void tryLockMethod() {
        if (LOCK.tryLock()) {
            System.out.printf("%s obtained lock!\n", Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                LOCK.unlock();
            }
        } else {
            System.err.printf("%s unable to acquire lock!\n", Thread.currentThread().getName());
        }
    }
}
