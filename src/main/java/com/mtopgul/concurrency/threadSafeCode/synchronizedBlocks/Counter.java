package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:20
 */
public class Counter {
    int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }

    public void execute() {
        increment();
        decrement();
    }
}
