package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:28
 */
public class ForLoopRunnableExample {
    public static void main(String[] args) {
        ForLoopRunnable runnable = new ForLoopRunnable();

        Thread thread1 = new Thread(runnable, "first-thread");
        Thread thread2 = new Thread(runnable, "second-thread");

        thread1.start();
        thread2.start();
    }
}
