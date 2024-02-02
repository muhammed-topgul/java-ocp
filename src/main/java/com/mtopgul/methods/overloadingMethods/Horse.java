package com.mtopgul.methods.overloadingMethods;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 15:49
 */
public class Horse {
    public static void walk(int[] ints) {
        System.out.println("int[]");
    }

    public static void walk(Integer[] integers) {
        System.out.println("Integer[]");
    }

    public static void walkNew(Integer[] integers) {
        System.out.println("Integer[]");
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3};
        walk(numbers);
        // walkNew(numbers); // DOES NOT COMPILE

        Integer[] sizes = {10, 20, 30};
        walk(sizes);
    }
}
