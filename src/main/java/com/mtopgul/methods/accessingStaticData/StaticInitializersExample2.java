package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 11:27
 */
public class StaticInitializersExample2 {
    private String name;
    private static int one;
    private static final int two;
    private static final int three = 3;
    // private static final int four; // DOES NOT COMPILE

    static {
        one = 1;
        one = 2;

        two = 2;
        // two = 2;  // DOES NOT COMPILE

        // three = 3;  // DOES NOT COMPILE

        // name = "Java";   // DOES NOT COMPILE

        int point = 5;
        System.out.println(point);

        // static count = 0;  // DOES NOT COMPILE
    }
}
