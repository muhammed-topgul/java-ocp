package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:11
 */
public class Counter {
    private static int count;

    public Counter() {
        count++;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println(count); // 3
    }
}
