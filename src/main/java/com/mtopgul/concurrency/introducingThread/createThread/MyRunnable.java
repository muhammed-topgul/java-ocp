package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:18
 */
public class MyRunnable implements Runnable {
    private final String parameter;

    public MyRunnable(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void run() {
        System.out.println("Important job running in MyRunnable: " + parameter);
    }
}
