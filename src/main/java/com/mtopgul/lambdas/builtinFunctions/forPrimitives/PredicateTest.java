package com.mtopgul.lambdas.builtinFunctions.forPrimitives;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 09:40
 */
public class PredicateTest {
    public static void main(String[] args) {
        // Double
        Predicate<Double> predicateDouble = x -> x <= 5;
        DoublePredicate doublePredicate = x -> x <= 5;
        System.out.println(predicateDouble.test(2.0));
        System.out.println(doublePredicate.test(2.0));

        // Int
        Predicate<Integer> predicateInt = x -> x > 10;
        IntPredicate intPredicate = x -> x > 10;
        System.out.println(predicateInt.test(45));
        System.out.println(intPredicate.test(45));

        // Long
        Predicate<Long> predicateLong = x -> x <= 5;
        LongPredicate longPredicate = x -> x <= 5;
        System.out.println(predicateLong.test(2L));
        System.out.println(longPredicate.test(2));
    }
}
