package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:19
 */
public class MyRunnableExample {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("Parameter-1");
        MyRunnable myRunnable2 = new MyRunnable("Parameter-2");
        MyRunnable myRunnable3 = new MyRunnable("Parameter-3");
        MyRunnable myRunnable4 = new MyRunnable("Parameter-4");
        MyRunnable myRunnable5 = new MyRunnable("Parameter-5");

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);
        Thread thread4 = new Thread(myRunnable4);
        Thread thread5 = new Thread(myRunnable5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
