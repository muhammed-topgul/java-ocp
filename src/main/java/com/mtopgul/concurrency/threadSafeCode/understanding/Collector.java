package com.mtopgul.concurrency.threadSafeCode.understanding;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 13:56
 */
public class Collector {
    private long sum;

    public synchronized void add(long value) {
        this.sum += value;
    }

    public long getSum() {
        return sum;
    }
}
