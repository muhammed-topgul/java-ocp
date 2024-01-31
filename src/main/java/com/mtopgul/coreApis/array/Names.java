package com.mtopgul.coreApis.array;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 07:36
 */
public class Names {
    String[] names1;

    String[] names2 = new String[2];

    public static void main(String[] args) {
        Names names = new Names();
        System.out.println(Arrays.toString(names.names1));
        System.out.println(Arrays.toString(names.names2));
    }
}
