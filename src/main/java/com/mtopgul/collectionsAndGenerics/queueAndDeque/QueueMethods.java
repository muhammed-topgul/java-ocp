package com.mtopgul.collectionsAndGenerics.queueAndDeque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 16:36
 */
public class QueueMethods {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(4);
        queue.offer(5);

        // Gets and does not remove element
        System.out.println(queue.peek());     // 10
        System.out.println(queue.element());  // 10 -> NoSuchElementException if queue is empty

        // Gets and removes element
        System.out.println(queue.remove());   // 10 -> NoSuchElementException if queue is empty
        System.out.println(queue.poll());     // 4

        System.out.println(queue);            // [5]
    }
}
