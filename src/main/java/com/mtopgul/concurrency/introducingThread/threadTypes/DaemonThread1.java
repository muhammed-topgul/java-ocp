package com.mtopgul.concurrency.introducingThread.threadTypes;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:44
 */
public class DaemonThread1 {
    public static void main(String[] args) {
        var job = new Thread(DaemonThread1::pause);
        job.setDaemon(true);
        job.start();
        System.out.println("Main method finished");
    }

    private static void pause() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread finished!");
    }

}
