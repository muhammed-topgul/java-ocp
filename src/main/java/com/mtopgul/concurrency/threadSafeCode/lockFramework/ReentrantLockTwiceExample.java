package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 13:13
 */
public class ReentrantLockTwiceExample {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        performTask();

        new Thread(ReentrantLockTwiceExample::performTask).start();
        new Thread(ReentrantLockTwiceExample::performTask).start();
        new Thread(ReentrantLockTwiceExample::performTask).start();
        new Thread(ReentrantLockTwiceExample::performTask).start();
    }

    private static void performTask() {
        if (LOCK.tryLock()) {
            System.out.printf("(+) Lock obtained by '%s'.\n", Thread.currentThread().getName());
            try {
                LOCK.lock();
                System.out.printf("(+) Lock obtained by '%s'.\n", Thread.currentThread().getName());
            } finally {
                System.out.printf("(-) Lock released by '%s'.\n", Thread.currentThread().getName());
                LOCK.unlock();
            }
        } else {
            System.err.printf("(x) Unable to acquire lock by '%s'.\n", Thread.currentThread().getName());
        }
    }
}
