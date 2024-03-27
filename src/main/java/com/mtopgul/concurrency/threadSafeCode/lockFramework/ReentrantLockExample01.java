package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:56
 */
public class ReentrantLockExample01 {
    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object) {
            // Protected code here
        }

        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            // Protected code here
        } finally {
            lock.unlock();
        }
    }
}
