package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:26
 */
public class ForLoopRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.printf("(%s) is running: %d\n", Thread.currentThread().getName(), i);
        }
    }
}
