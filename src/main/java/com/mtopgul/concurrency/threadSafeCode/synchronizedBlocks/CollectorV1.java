package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:10
 */
public class CollectorV1 {
    private long sum;

    public synchronized void addV1(long value) {
        this.sum += value;
    }

    public void addV2(long value) {
        synchronized (this) {
            this.sum += value;
        }
    }

    public long getSum() {
        return sum;
    }
}
