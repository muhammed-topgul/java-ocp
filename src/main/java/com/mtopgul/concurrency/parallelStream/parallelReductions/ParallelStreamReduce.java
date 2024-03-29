package com.mtopgul.concurrency.parallelStream.parallelReductions;

import com.mtopgul.Util;

import java.util.List;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 15:34
 */
public class ParallelStreamReduce {
    public static void main(String[] args) {
        serialStreamReduce();

        parallelStreamReduce();
    }

    private static List<Character> chars() {
        return List.of('w', 'o', 'l', 'f');
    }

    private static void serialStreamReduce() {
        Util.divide("Serial Stream Reduce", 0);
        String reduce = chars().stream()
                .reduce("", (s1, c) -> s1 + c, (s2, s3) -> {
                    System.out.println("Not invoked on serial stream!");
                    throw new IllegalArgumentException();
                });
        System.out.println(reduce);
    }

    private static void parallelStreamReduce() {
        Util.divide("Parallel Stream Reduce");
        String reduce = chars().parallelStream()
                .reduce("", (s1, c) -> s1 + c, (s2, s3) -> s2 + s3);
        System.out.println(reduce);
    }
}
