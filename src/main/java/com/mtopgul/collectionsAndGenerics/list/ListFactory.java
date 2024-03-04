package com.mtopgul.collectionsAndGenerics.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/03/2024 08:58
 */
public class ListFactory {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        List<String> asList = Arrays.asList(array); // [a, b, c]
        List<String> of = List.of(array);           // [a, b, c]
        List<String> copyOf = List.copyOf(asList);  // [a, b, b]

        array[0] = "z";

        System.out.println(asList);    // [z, b, c]
        System.out.println(of);        // [a, b, c]
        System.out.println(copyOf);    // [a, b, c]

        asList.set(0, "x");
        System.out.println(Arrays.toString(array)); // [x, b, c]
        copyOf.add("y");                            // UnsupportedOperationException

        var list = new ArrayList<>();
    }
}
