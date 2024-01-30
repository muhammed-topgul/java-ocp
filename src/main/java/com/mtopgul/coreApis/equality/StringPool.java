package com.mtopgul.coreApis.equality;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 11:23
 */
public class StringPool {
    public static void main(String[] args) {
        equalityCheck();
//        System.out.println("################");
//        finalString();
//        System.out.println("################");
//        finalStringV1();
//        System.out.println("################");
//        finalStringV2();
    }

    private static void equalityCheck() {
        var x = "Hello World";
        var y = "Hello World";
        var z = "Hello " + "World";
        System.out.println(x == y); // true
        System.out.println(x == z); // true

        var part1 = "Hello";
        var part2 = " World";
        var part3 = part1 + part2;

        System.out.println(x == part3); // false
        System.out.println(x == z);     // true

        System.out.println(x == " Hello World".trim()); // false

        var concat = "Hello ";
        concat += "World";

        System.out.println(x == concat);        // false
        System.out.println(x.equals(concat));   // true

        System.out.println(x == new String(x));          // false
        System.out.println(x == new String(x).intern()); // true

        var first = "rat" + 1;
        var second = "r" + "a" + "t" + "1";
        var third = "r" + "a" + "t" + new String("1");
        System.out.println(first == second);         // true
        System.out.println(first == third);          // false
        System.out.println(first == third.intern()); // true
    }

    private static void finalString() {
        // Only literals and constants strings located in String Pool
        String fullMsg = "Hello World";
        final String msg1 = "Hello ";
        final String msg2 = "World";
        String msg3 = msg1 + msg2;

        System.out.println(fullMsg == msg3); // true
    }

    private static void finalStringV1() {
        // Only literals and constants strings located in String Pool
        String fullMsg = "Hello World";
        String msg1 = "Hello ";
        String msg2 = "World";
        String msg3 = msg1 + msg2;

        System.out.println(fullMsg == msg3); // false
    }

    private static void finalStringV2() {
        // Only literals and constants strings located in String Pool
        String fullMsg = "Hello World";
        final String msg1 = hello();
        final String msg2 = world();
        String msg3 = msg1 + msg2;

        System.out.println(fullMsg == msg3);       // false
        System.out.println(fullMsg.equals(msg3));  // true
    }

    private static String hello() {
        return "Hello ";
    }

    private static String world() {
        return "World";
    }
}