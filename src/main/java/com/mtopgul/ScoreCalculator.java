package com.mtopgul;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 29/09/2024 18:00
 */
public class ScoreCalculator {
    private final static Scanner scanner = new Scanner(System.in);
    private static int questionsCount = 0;
    private static int correctAnswersCount = 0;
    private static double partialTotal = 0;

    public static void main(String[] args) {
        System.out.print("Exam Name: ");
        String examName = scanner.nextLine();
        calculate(examName);
    }

    private static void calculate(String examName) {
        Predicate<String> correct = s -> s.startsWith("✅");
        Predicate<String> partially = s -> s.startsWith("☑\uFE0F");
        Predicate<String> wrong = s -> s.startsWith("❌");
        Predicate<String> questions = correct.or(wrong).or(partially);

        InputStream fileResource = ClassLoader.getSystemResourceAsStream("test/sybex/study-guide/test02/" + examName);
        if (Objects.isNull(fileResource)) {
            System.err.println(examName + " file not found!");
            return;
        }
        Stream<String> stream = new BufferedReader(new InputStreamReader(fileResource)).lines();
        stream.filter(questions)
                .forEach(s -> {
                    questionsCount++;
                    if (correct.test(s)) {
                        correctAnswersCount++;
                    } else if (partially.test(s)) {
                        int length = s.length();
                        int beginIndex = s.indexOf("(");
                        String optionsCount = s.substring(beginIndex + 1, beginIndex + 2);
                        String correctCount = s.substring(length - 2, length - 1);
                        partialTotal += (double) Integer.parseInt(correctCount) / Integer.parseInt(optionsCount);
                    }
                });
        double perQuestionRate = 100.0 / questionsCount;
        double total = (perQuestionRate * correctAnswersCount) + (partialTotal * perQuestionRate);
        System.out.printf("Score: %.2f",  total);
    }
}
