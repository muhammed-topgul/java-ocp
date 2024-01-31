package com.mtopgul.coreApis.array;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 08:11
 */
public class UsingCompare {
    public static void main(String[] args) {
        System.out.println(Arrays.compare(new int[]{1}, new int[]{1}));    // 0
        System.out.println(Arrays.compare(new int[]{1}, new int[]{1, 2})); // NEGATIVE
        System.out.println(Arrays.compare(new int[]{1, 2}, new int[]{1})); // POSITIVE

        System.out.println(Arrays.compare(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{2})); // NEGATIVE
        System.out.println(Arrays.compare(new int[]{1, 3}, new int[]{1}));                // POSITIVE
        System.out.println(Arrays.compare(new int[]{1, 3}, new int[]{1, 2}));             // POSITIVE
        System.out.println(Arrays.compare(new int[]{1, 2, 3}, new int[]{1, 2}));          // POSITIVE
        System.out.println(Arrays.compare(new int[]{2}, new int[]{1, 2, 3, 4, 5, 6, 7})); // POSITIVE
        System.out.println(Arrays.compare(new int[]{2}, null));                           // POSITIVE

        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"aa"})); // NEGATIVE
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"A"}));  // POSITIVE
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"Z"}));  // POSITIVE
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"z"}));  // NEGATIVE
        System.out.println(Arrays.compare(new String[]{"a"}, null));               // POSITIVE
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{null})); // POSITIVE

        // System.out.println(Arrays.compare(new String[]{"a"}, new int[]{1})); // DOES NOT COMPILE
    }
}
