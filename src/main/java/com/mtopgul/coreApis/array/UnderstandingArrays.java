package com.mtopgul.coreApis.array;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 11:44
 */
public class UnderstandingArrays {
    public static void main(String[] args) {
        char[] letters1 = null;
        char[] letters2 = new char[5];
        char[] letters3 = {'a', 'b', 'c'};

        System.out.println(letters2 instanceof Object); // true
        System.out.println(letters3.getClass());        // class [C
        System.out.println(letters3 instanceof char[]); // true

        int[] numbers = null;
        System.out.println(numbers);
        System.out.println(letters1); // NullPointerException
    }
}
