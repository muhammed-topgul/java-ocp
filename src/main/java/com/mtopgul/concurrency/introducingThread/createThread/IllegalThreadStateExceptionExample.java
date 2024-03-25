package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:23
 */
public class IllegalThreadStateExceptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello!"));
        thread.start();
        thread.start(); // IllegalThreadStateException
    }
}
