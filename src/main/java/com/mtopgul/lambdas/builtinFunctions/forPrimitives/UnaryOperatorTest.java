package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:54
 */
public class UnaryOperatorTest {
    public static void main(String[] args) {
        // Double
        UnaryOperator<Double> unaryOperatorDouble = x -> x * 3;
        DoubleUnaryOperator doubleUnaryOperator = x -> x * 3;
        System.out.println(unaryOperatorDouble.apply(5d));
        System.out.println(doubleUnaryOperator.applyAsDouble(5));

        // Int
        UnaryOperator<Integer> unaryOperatorInt = x -> x * 2;
        IntUnaryOperator intUnaryOperator = x -> x + 2;
        System.out.println(unaryOperatorInt.apply(2));
        System.out.println(intUnaryOperator.applyAsInt(2));

        // Long
        UnaryOperator<Long> unaryOperatorLong = x -> x * 3;
        LongUnaryOperator longUnaryOperator = x -> x + 3;
        System.out.println(unaryOperatorLong.apply(5L));
        System.out.println(longUnaryOperator.applyAsLong(2));
    }
}
