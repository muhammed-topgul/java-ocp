package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 10:02
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        // Double
        BinaryOperator<Double> binaryOperatorDouble = (x, y) -> x / y;
        DoubleBinaryOperator doubleBinaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperatorDouble.apply(2.4, 4.0));
        System.out.println(doubleBinaryOperator.applyAsDouble(2, 5.4));

        // Int
        BinaryOperator<Integer> binaryOperatorInt = (x, y) -> x / y;
        IntBinaryOperator intBinaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperatorInt.apply(2, 4));
        System.out.println(intBinaryOperator.applyAsInt(2, 5));

        // Long
        BinaryOperator<Long> binaryOperatorLong = (x, y) -> x / y;
        LongBinaryOperator longBinaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperatorLong.apply(2L, 4L));
        System.out.println(longBinaryOperator.applyAsLong(2, 5L));
    }
}
