package com.mtopgul.concurrency.threadSafeCode.understanding;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 14:09
 */
public class Counter {
    int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
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
