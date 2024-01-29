package com.mtopgul.coreApis.array.mismatch;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 29/01/2024 08:43
 */
public class Mismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1})); // -1
        System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"})); // 0
        System.out.println(Arrays.mismatch(new int[]{1, 2}, new int[]{1})); // 1
    }
}
