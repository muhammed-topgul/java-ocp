package com.mtopgul.coreApis.array.searching;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 07:42
 */
public class Search {
    public static void main(String[] args) {
        {
            int[] numbers = {2, 4, 6, 8};
            System.out.println(Arrays.binarySearch(numbers, 2)); // 0
            System.out.println(Arrays.binarySearch(numbers, 6)); // 2
            System.out.println(Arrays.binarySearch(numbers, 1)); // -1
            System.out.println(Arrays.binarySearch(numbers, 3)); // -2
            System.out.println(Arrays.binarySearch(numbers, 9)); // -5
        }

        {
            int[] numbers = new int[]{3, 2, 1};
            System.out.println(Arrays.binarySearch(numbers, 2)); // 1
            System.out.println(Arrays.binarySearch(numbers, 3)); // -4
        }
    }
}
