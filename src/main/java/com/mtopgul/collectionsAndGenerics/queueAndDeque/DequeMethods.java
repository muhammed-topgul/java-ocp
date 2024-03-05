package com.mtopgul.collectionsAndGenerics.queueAndDeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 16:45
 */
public class DequeMethods {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(2);    // [2]
        deque.offerFirst(1);  // [1, 2]
        deque.offer(3);       // [1, 2, 3]
        deque.offerLast(4);   // [1, 2, 3, 4]
        deque.addLast(5);     // [1, 2, 3, 4, 5]

        deque.poll();            // [2, 3, 4, 5]
        deque.pollFirst();       // [3, 4, 5]
        deque.peek();            // [3, 4, 5]
        deque.peekLast();        // [3, 4, 5]
        deque.getLast();         // [3, 4, 5]
        deque.peekFirst();       // [3, 4, 5]
        deque.getFirst();        // [3, 4, 5]

        deque.removeFirst();     // [4, 5]
        deque.removeLast();      // [4]

        System.out.println(deque);
    }
}
