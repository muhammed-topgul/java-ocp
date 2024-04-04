package com.mtopgul.io.readingAndWritingFiles.enhancingWithFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 13:13
 */
public class FilesLinesExample01 {
    public static void main(String[] args) throws IOException {
        Path input = Path.of("extras/ch14/lorem-ipsum.txt");
        readLazily(input);
    }

    private static void readLazily(Path path) throws IOException {
        Stream<String> lines = Files.lines(path);
        try(lines) {
            lines.forEach(System.out::println);
        }
    }
}
