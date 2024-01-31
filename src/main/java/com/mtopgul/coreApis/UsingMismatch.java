package com.mtopgul.coreApis;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 08:25
 */
public class UsingMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1}));    // -1
        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{0}));    // 0
        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1, 2})); // 1
        System.out.println(Arrays.mismatch(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})); // 4

        System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"})); // 0
    }
}
