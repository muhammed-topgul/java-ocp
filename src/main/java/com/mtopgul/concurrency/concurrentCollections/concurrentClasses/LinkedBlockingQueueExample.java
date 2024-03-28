package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:38
 */
public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(91);
            blockingQueue.offer(6, 2, TimeUnit.MINUTES);
            blockingQueue.offer(5, 100, TimeUnit.MICROSECONDS);

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(950, TimeUnit.MICROSECONDS));

            System.out.println(blockingQueue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
