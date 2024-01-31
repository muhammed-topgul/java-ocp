package com.mtopgul.coreApis.array;

import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 07:30
 */
public class CreatingAnArrayWithReferenceVariables {
    public static void main(String[] args) {
        String[] names = {"cricket", "beetle", "ladybug"};
        System.out.println(names);
        System.out.println(Arrays.toString(names));

        int[] numbers1 = {1, 2, 3, 4, 5};
        System.out.println(numbers1);
        System.out.println(Arrays.toString(numbers1));

        int[] numbers2 = {1, 2, 3, 4, 5};
        System.out.println(numbers2);
        System.out.println(Arrays.toString(numbers2));

        System.out.println(numbers1.equals(numbers2));         // false
        System.out.println(numbers1 == numbers2);              // false
        System.out.println(Arrays.equals(numbers1, numbers2)); // true
    }
}
