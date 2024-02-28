package com.mtopgul.lambdas.builtinFunctions;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author muhammed-topgul
 * @since 28/02/2024 08:50
 */
public class ConvenienceMethods {
    public static void main(String[] args) {
        // predicate();

        // consumer();

        function();
    }

    private static void predicate() {
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        {
            Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
            Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");
            System.out.println(brownEggs.test("brown egg"));
            System.out.println(otherEggs.test("red egg"));
        }
        {
            Predicate<String> brownEggs = s -> egg.test(s) && brown.test(s);
            Predicate<String> otherEggs = s -> egg.test(s) && !brown.test(s);
            System.out.println(brownEggs.test("brown egg"));
            System.out.println(otherEggs.test("red egg"));
        }
        {
            Predicate<String> brownEggs = egg.and(brown);
            Predicate<String> otherEggs = egg.and(brown.negate());
            System.out.println(brownEggs.test("brown egg"));
            System.out.println(otherEggs.test("red egg"));
        }
    }

    private static void consumer() {
        Consumer<String> consumer1 = x -> System.out.print("1: " + x);
        Consumer<String> consumer2 = x -> System.out.print(", 2: " + x);
        Consumer<String> combined = consumer1.andThen(consumer2);
        combined.accept("Annie");
    }

    private static void function() {
        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;
        Function<Integer, Integer> andThan = after.andThen(before);
        Function<Integer, Integer> combined = after.compose(before);
        System.out.println(andThan.apply(3));  // 7
        System.out.println(combined.apply(3)); // 8
    }
}
