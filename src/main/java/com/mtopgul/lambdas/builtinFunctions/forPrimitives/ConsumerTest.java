package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:35
 */
public class ConsumerTest {
    public static void main(String[] args) {
        // Double
        Consumer<Double> consumerDouble = System.out::println;
        DoubleConsumer doubleConsumer = System.out::println;
        consumerDouble.accept(1.0);
        doubleConsumer.accept(1);

        // Int
        Consumer<Integer> consumerInt = System.out::println;
        IntConsumer intConsumer = System.out::println;
        consumerInt.accept(5);
        intConsumer.accept(4);

        // Long
        Consumer<Long> consumerLong = System.out::println;
        LongConsumer longConsumer = System.out::println;
        consumerLong.accept(3L);
        longConsumer.accept(1);
    }
}
