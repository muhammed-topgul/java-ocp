package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:01
 */
public class Example02 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello " + Thread.currentThread().getName() + "#")).start();
        System.out.println("World " + Thread.currentThread().getName() + "#");
    }
}
