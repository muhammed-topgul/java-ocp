package com.mtopgul.lambdas.training;

import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author muhammed-topgul
 * @since 26/09/2024 14:43
 */
public class BuiltInFunctions {
    public static void main(String[] args) {
        supplier();
        consumer();
        predicate();
        function();
        operator();
    }

    private static void supplier() {
        System.out.println("> Supplier");
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        Supplier<LocalDate> s2 = LocalDate::now;

        System.out.println(s1); // com.mtopgul.lambdas.training.BuiltInFunctions$$Lambda/0x0000020031003200@4e50df2e
        System.out.println(s1.get()); // 2024-09-26
        System.out.println(s2.get()); // 2024-09-26
    }

    private static void consumer() {
        System.out.println("\n\n> Consumer and BiConsumer");

        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<Integer> c2 = System.out::println;

        c1.accept("Java"); // Java
        c2.accept(5);      // 5

        BiConsumer<String, String> bc1 = (s1, s2) -> System.out.println(s1 + s2);
        BiConsumer<String, Integer> bc2 = (s, i) -> System.out.println(s.length() + i);

        bc1.accept("Java", "SE"); // JavaSE
        bc2.accept("Java", 17);   // 21
    }

    private static void predicate() {
        System.out.println("\n\n> Predicate and BiPredicate");

        Predicate<String> p1 = s -> s.length() == 6;
        Predicate<String> p2 = s -> {
            return s.length() == 6;
        };
        System.out.println(p1.test("Java"));   // false
        System.out.println(p2.test("Spring")); // true

        BiPredicate<String, Integer> bp = (s, i) -> s.length() + i == 10;
        System.out.println(bp.test("Java", 6)); // true
    }

    private static void function() {
        System.out.println("\n\n> Function and BiFunction");

        Function<String, Integer> f1 = (s) -> s.length();
        Function<Integer, Integer> f2 = (i) -> i * i;

        System.out.println(f1.apply("Java")); // 4
        System.out.println(f2.apply(2));      // 9

        BiFunction<Integer, String, Boolean> bf1 = (i, s) -> i == s.length();
        System.out.println(bf1.apply(4, "Java"));
    }

    private static void operator() {
        System.out.println("\n\n> UnaryOperator and BinaryOperator");

        UnaryOperator<String> u1 = (s) -> s.concat("_new_text");
        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);

        System.out.println(u1.apply("Java")); // Java_new_text
        System.out.println(b1.apply("Java", "17")); // Java17
    }
}
