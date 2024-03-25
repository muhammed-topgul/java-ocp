package com.mtopgul.concurrency.introducingThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 18:11
 */
public class PollingWithSleep {
    private static int counter = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000_000; i++) {
                counter++;
            }
        }).start();

        while (counter < 1_000_000_000) {
            System.out.printf("Not reached yet. (%d)\n", counter);
        }

        System.out.println("Reached: " + counter);
    }
}
