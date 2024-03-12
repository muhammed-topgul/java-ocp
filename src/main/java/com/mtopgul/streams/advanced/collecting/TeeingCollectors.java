package com.mtopgul.streams.advanced.collecting;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muhammed-topgul
 * @since 12/03/2024 08:10
 */
public class TeeingCollectors {
    private static record Separations(String spaceSeparated, String commaSeparated) {
    }

    public static void main(String[] args) {
        var list = List.of("x", "y", "z");

        Separations separations = list.stream()
                .collect(Collectors.teeing(
                        Collectors.joining(" "),
                        Collectors.joining(","),
                        (s, c) -> new Separations(s, c)
                ));

        System.out.println(separations);  // Separations[spaceSeparated=x y z, commaSeparated=x,y,z]


    }
}
