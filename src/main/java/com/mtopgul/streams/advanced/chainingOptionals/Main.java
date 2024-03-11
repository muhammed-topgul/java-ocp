package com.mtopgul.streams.advanced.chainingOptionals;

import java.util.Optional;

/**
 * @author muhammed-topgul
 * @since 11/03/2024 12:47
 */
public class Main {
    public static void main(String[] args) {
        threeDigitOldStyle(Optional.of(313));
        threeDigitStreamStyle(Optional.of(568));
        threeDigitStreamStyle(Optional.empty());
    }

    private static void threeDigitStreamStyle(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() >= 3)
                .ifPresent(System.out::println);
    }

    private static void threeDigitOldStyle(Optional<Integer> optional) {
        if (optional.isPresent()) {
            var num = optional.get();
            var string = "" + num;
            if (string.length() >= 3) {
                System.out.println(string);
            }
        }
    }
}
