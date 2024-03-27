package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:05
 */
public class SynchronizedOnMethods {
    void signV1() {
        synchronized (this) {
            System.out.print("La la la!");
        }
    }

    synchronized void signV2() {
        System.out.print("La la la!");
    }

    static void danceV1() {
        synchronized (SynchronizedOnMethods.class) {
            System.out.print("Time to dance!");
        }
    }

    static synchronized void danceV2() {
        System.out.print("Time to dance");
    }

    static void danceV3() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.mtopgul.concurrency.threadSafeCode.understanding.SheepManager");
        synchronized (clazz) {
            System.out.print("Time to dance!");
        }
    }
}
