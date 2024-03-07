package com.mtopgul.streams.optional;

import java.util.Optional;

/**
 * @author muhammed-topgul
 * @since 07/03/2024 12:56
 */
public class CreatingOptional {
    public static void main(String[] args) {
        printOptional(average(90, 100));
        printOptional(average());

        System.out.println(Optional.ofNullable(getNullableText()));
        System.out.println(Optional.of(getNullableText())); // Throws exception if getNullableText() is null
    }

    private static String getNullableText() {
        double random = Math.random();
        if (random < 0.5) {
            return null;
        }
        return "Java";
    }

    private static <T extends Number> void printOptional(Optional<T> optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("No data");
        }
    }

    private static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of(sum / scores.length);
    }
}
