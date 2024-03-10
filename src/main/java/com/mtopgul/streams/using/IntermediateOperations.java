package com.mtopgul.streams.using;

import java.util.stream.Stream;

import static com.mtopgul.streams.using.TerminalOperations.primates;

/**
 * @author muhammed-topgul
 * @since 10/03/2024 18:17
 */
public class IntermediateOperations {
    public static void main(String[] args) {
        // filter()
        primates().filter(x -> x.startsWith("M"))
                .forEach(System.out::println);    // Monkey

        // distinct()
        duckStream().distinct()
                .forEach(System.out::print);     // duckgoose
    }

    private static Stream<String> duckStream() {
        return Stream.of("duck", "duck", "duck", "goose");
    }
}
