package com.mtopgul.concurrency.threadSafeCode.synchronizedBlocks;

/**
 * @author muhammed-topgul
 * @since 27/03/2024 09:10
 */
public class CollectorV2 {
    private static long sum;

    public static synchronized void addV1(long value) {
        sum += value;
    }

    public static void addV2(long value) {
        synchronized (CollectorV2.class) {
            sum += value;
        }
    }

    public static long getSum() {
        return sum;
    }
}
