package com.mtopgul.concurrency.introducingThread.createThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 17:05
 */
public class Example03 {
    public static void main(String[] args) {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };
        System.out.println("Begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printInventory).start();
        System.out.println("end");
    }
}
