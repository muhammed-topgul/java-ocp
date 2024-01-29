package com.mtopgul.coreApis.array.comparing;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 07:48
 */
public class Compare {
    public static void main(String[] args) {
        System.out.println(Arrays.compare(new int[]{1}, new int[]{2}));            // -1
        System.out.println(Arrays.compare(new int[]{1, 2}, new int[]{1}));         // 1
        System.out.println(Arrays.compare(new int[]{1, 2}, new int[]{1, 2}));      // 0
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"aa"})); // -1
        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{null})); // 1
        System.out.println(Arrays.compare(new int[]{4, 5, 7}, new int[]{15,1,9})); // -1
        // System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"}));     // DOES NOT COMPILE
    }
}
