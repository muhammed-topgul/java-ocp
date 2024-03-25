package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:00
 */
public class Example01 {
    public static void main(String[] args) {
        new Thread(() -> System.out.print("Hello")).start();
        System.out.print("World");
    }
}
