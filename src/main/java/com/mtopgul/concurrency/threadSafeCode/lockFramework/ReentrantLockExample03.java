package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 10:04
 */
public class ReentrantLockExample03 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Lock lock = new ReentrantLock();

        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> printHello(lock));
        }
    }

    public static void printHello(Lock lock) {
        try {
            lock.lock();
            System.out.println("Hello! ThreadName: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
