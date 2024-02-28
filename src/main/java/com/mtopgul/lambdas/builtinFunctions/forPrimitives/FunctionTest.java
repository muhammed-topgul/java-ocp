package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:48
 */
public class FunctionTest {
    public static void main(String[] args) {
        // Double
        Function<Double, Integer> functionDouble = x -> x.intValue();
        DoubleFunction<Integer> doubleFunction = x -> (int) x;
        System.out.println(functionDouble.apply(10.1));
        System.out.println(doubleFunction.apply(10));

        // Int
        Function<Integer, Integer> functionInt = x -> x * 3;
        IntFunction<Integer> intFunction = x -> x * 3;
        System.out.println(functionInt.apply(10));
        System.out.println(intFunction.apply(10));

        // Long
        Function<Long, Integer> functionLong = x -> Math.toIntExact(x * 8);
        LongFunction<Integer> longFunction = x -> (int) x;
        System.out.println(functionLong.apply(10L));
        System.out.println(longFunction.apply(10));
    }
}
