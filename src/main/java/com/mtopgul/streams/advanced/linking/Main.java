package com.mtopgul.streams.advanced.linking;

import java.util.ArrayList;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 12:40
 */
public class Main {
    public static void main(String[] args) {
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripley");
        var stream = cats.stream();
        cats.add("KC");

        long count = stream.filter(s -> s.length() >= 2)
                .peek(s -> System.out.println(s))
                .count();
        System.out.println(count); // 3
    }
}
