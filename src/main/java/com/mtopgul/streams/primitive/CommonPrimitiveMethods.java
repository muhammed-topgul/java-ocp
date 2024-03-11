package com.mtopgul.streams.primitive;

import com.mtopgul.Util;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 10:22
 */
public class CommonPrimitiveMethods {
    public static void main(String[] args) {
        DoubleStream empty = DoubleStream.empty();
        empty.forEach(System.out::println);

        DoubleStream oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println);

        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        varargs.forEach(System.out::println);

        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3)
                .forEach(System.out::println);
        fractions.limit(3)
                .forEach(System.out::println);

        Util.divide("iterate()");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::print); // 12345

        Util.divide("range()", 2);
        IntStream.range(1, 6)
                .forEach(System.out::print); // 12345

        Util.divide("rangeClosed()", 2);
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::print); // 12345
    }
}
