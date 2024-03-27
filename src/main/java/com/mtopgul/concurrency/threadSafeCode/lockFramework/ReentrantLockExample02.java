package com.mtopgul.concurrency.threadSafeCode.lockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:58
 */
public class ReentrantLockExample02 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.unlock(); // IllegalMonitorStateException
    }
}
