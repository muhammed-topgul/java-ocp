package com.mtopgul.lambdas.builtinFunctions;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 19:17
 */
public class PredicateTest {
    public static void main(String[] args) {
        {
            Predicate<String> predicate1 = x -> x.isEmpty();
            Predicate<String> predicate2 = String::isEmpty;

            System.out.println(predicate1.test(""));
            System.out.println(predicate2.test(""));
        }

        {
            BiPredicate<String, String> predicate1 = (a, b) -> a.startsWith(b);
            BiPredicate<String, String> predicate2 = String::startsWith;

            System.out.println(predicate1.test("chicken", "chick")); // true
            System.out.println(predicate2.test("chicken", "chick")); // true
        }
    }
}
