package com.mtopgul.concurrency.concurrentCollections.concurrentClasses;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author muhammed-topgul
 * @since 28/03/2024 17:26
 */
public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(10);
        queue.offer(20);

        System.out.println(queue);        // [10, 20]
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 20
    }
}
