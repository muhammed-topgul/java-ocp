package com.mtopgul.collectionsAndGenerics.queueAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 07:41
 */
public class DequeAsStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);  // [1]
        stack.push(2);  // [2, 1]

        System.out.println(stack.peek()); // 2
        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop());  // 4
        System.out.println(stack.pop());  // 1

        System.out.println(stack.peek()); // null
        System.out.println(stack.pop());  // NoSuchElementException
        System.out.println(stack);
    }
}
