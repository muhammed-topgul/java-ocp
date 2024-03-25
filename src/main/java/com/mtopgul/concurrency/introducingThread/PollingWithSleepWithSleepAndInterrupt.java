package com.mtopgul.concurrency.introducingThread;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 18:11
 */
public class PollingWithSleepWithSleepAndInterrupt {
    private static int counter = 0;

    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();
        new Thread(() -> {
            for (int i = 0; i < 1_000_000_000; i++) {
                counter++;
            }
            mainThread.interrupt();
        }).start();

        while (counter < 1_000_000_000) {
            System.out.printf("Not reached yet. (%d)\n", counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println(mainThread.isInterrupted());
        System.out.println("Reached: " + counter);
    }
}
