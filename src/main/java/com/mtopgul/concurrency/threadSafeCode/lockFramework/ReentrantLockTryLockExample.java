package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 16:40
 */
public class ReentrantLockTryLockExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(() -> printHello(lock)).start();

        Thread.sleep(200);

        if (lock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code!");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }

    public static void printHello(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(400);
            System.out.println("Hello");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
