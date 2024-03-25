package com.mtopgul.concurrency.introducingThread.threadTypes;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:50
 */
public class DaemonThread2 extends Thread {
    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread work");
        } else {
            System.out.println("User thread work");
        }
    }

    public static void main(String[] args) {
        DaemonThread2 t1 = new DaemonThread2();
        DaemonThread2 t2 = new DaemonThread2();
        DaemonThread2 t3 = new DaemonThread2();

        t1.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}
