package com.mtopgul.concurrency.threadSafeCode.atomicClasses;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 16:27
 */
public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);

        System.out.println("get: " + atomicInteger.get());
        System.out.println("getAndIncrement: " + atomicInteger.getAndIncrement());
        System.out.println("getAndDecrement: " + atomicInteger.getAndDecrement());
        System.out.println("addAndGet: " + atomicInteger.addAndGet(500));

        atomicInteger.set(200);

        System.out.println("After set: " + atomicInteger);

        int oldValue = atomicInteger.getAndSet(300);
        System.out.println("getAndSet 'oldValue': " + oldValue);

        System.out.println("getAndDecrement: " + atomicInteger.getAndDecrement());
        System.out.println("decrementAndGet: " + atomicInteger.decrementAndGet());
    }
}
