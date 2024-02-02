package com.mtopgul.methods.accessingStaticData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:32
 */
public class StaticInitializersExample3 {
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        System.out.println("static initializer - 1");
        numbers.add(10);
        numbers.add(20);
    }

    static {
        System.out.println("static initializer - 2");
        numbers.add(30);
        numbers.add(40);
    }

    public static void main(String[] args) {
        System.out.println("main method");
        System.out.println(numbers);
    }
}
