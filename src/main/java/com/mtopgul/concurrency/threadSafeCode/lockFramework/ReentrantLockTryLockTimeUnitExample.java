package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 13:07
 */
public class ReentrantLockTryLockTimeUnitExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(() -> printHello(lock)).start();

        TimeUnit.MILLISECONDS.sleep(500);

        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println("Lock obtained!");
            } finally {
                lock.unlock();
            }
        } else {
            System.err.println("Unable to acquire lock!");
        }
    }

    private static void printHello(Lock lock) {
        try {
            lock.lock();
            System.out.println("Hello");
           TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
