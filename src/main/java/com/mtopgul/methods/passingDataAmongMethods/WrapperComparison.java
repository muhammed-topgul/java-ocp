package com.mtopgul.methods.passingDataAmongMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 14:53
 */
public class WrapperComparison {
    public static void main(String[] args) {
        compare1();
        compare2();
    }

    private static void compare1() {
        int i1 = 1000;
        Integer i2 = 1000;

        long l1 = 1000;
        Long l2 = 1000L;

        System.out.println(i1 == l1); // true
        System.out.println(i1 == l2); // true
        System.out.println(i2 == l1); // true

        System.out.println(i1 == i2); // true
        System.out.println(l1 == l2); // true

        // System.out.println(i2 == l2);  // DOES NOT COMPILE
    }

    private static void compare2() {
        System.out.println("\n");
        Integer i1 = 100;
        Integer i2 = 100;

        System.out.println("i1 == i2: " + (i1 == i2));           // true
        System.out.println("i1.equals(i2): " + (i1.equals(i2))); // true

        Integer i3 = 1000;
        Integer i4 = 1000;

        System.out.println("i3 == i4: " + (i3 == i4));           // false
        System.out.println("i3.equals(i4): " + (i3.equals(i4))); // true

        // -Djava.lang.Integer.IntegerCache.high=2000 ile wrapper integer için cahce boyutunu artırabiliriz.
    }
}
