package com.mtopgul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 29/09/2024 18:00
 */
public class Calculator {
    public static void main(String[] args) {
        Predicate<String> correct = s -> s.startsWith("✅");
        Predicate<String> wrong = s -> s.startsWith("☑\uFE0F");
        Predicate<String> partially = s -> s.startsWith("❌");
        Predicate<String> questions = correct.or(wrong).or(partially);


        Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("exams/ch09-collections-and-generics_0"))).lines();
        stream.filter(questions)
                .forEach(System.out::println);
    }

}
