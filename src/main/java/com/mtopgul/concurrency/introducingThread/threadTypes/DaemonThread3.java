package com.mtopgul.concurrency.introducingThread.threadTypes;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:53
 */
public class DaemonThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("Daemon: " + Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        DaemonThread3 t1 = new DaemonThread3();
        DaemonThread3 t2 = new DaemonThread3();

        t1.start();
        t1.setDaemon(true); // IllegalThreadStateException

        t2.start();
    }
}
