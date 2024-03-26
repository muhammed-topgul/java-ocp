package com.mtopgul.concurrency.threadSafeCode.atomicClasses;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 16:27
 */
public class AtomicLongExample {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(100);

        System.out.println("get: " + atomicLong.get());
        System.out.println("getAndIncrement: " + atomicLong.getAndIncrement());
        System.out.println("getAndDecrement: " + atomicLong.getAndDecrement());
        System.out.println("addAndGet: " + atomicLong.addAndGet(500));

        atomicLong.set(200);

        System.out.println("After set: " + atomicLong);

        long oldValue = atomicLong.getAndSet(300);
        System.out.println("getAndSet 'oldValue': " + oldValue);

        System.out.println("getAndDecrement: " + atomicLong.getAndDecrement());
        System.out.println("decrementAndGet: " + atomicLong.decrementAndGet());
    }
}
