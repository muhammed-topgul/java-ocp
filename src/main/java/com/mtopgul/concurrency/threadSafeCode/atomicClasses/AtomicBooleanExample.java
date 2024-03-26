package com.mtopgul.concurrency.threadSafeCode.atomicClasses;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 16:32
 */
public class AtomicBooleanExample {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println("get: " + atomicBoolean.get());

        atomicBoolean.set(true);

        System.out.println("After set: " + atomicBoolean.get());
    }
}
