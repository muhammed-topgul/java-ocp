package com.mtopgul.io.readingAndWritingFiles.enhancingWithFiles;

import com.mtopgul.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 12:56
 */
public class FilesReadWriteExample {
    public static void main(String[] args) throws IOException {
        Path input = Path.of("extras/ch14/lorem-ipsum.txt");
        Path output = Path.of("extras/ch14");

        copyPathAsString(input, output);
        Util.divide();

        copyPathAsBytes(input, output);
        Util.divide();

        copyAllPathAsLines(input, output);
    }

    private static void copyPathAsString(Path input, Path output) throws IOException {
        output = output.resolve("lorem-ipsum-out01.txt");

        String string = Files.readString(input);
        System.out.println(string);
        Files.writeString(output, string);
    }

    private static void copyPathAsBytes(Path input, Path output) throws IOException {
        output = output.resolve("lorem-ipsum-out02.txt");

        byte[] allBytes = Files.readAllBytes(input);
        for (byte b : allBytes) {
            System.out.print((char) b);
        }
        Files.write(output, allBytes);
    }

    private static void copyAllPathAsLines(Path input, Path output) throws IOException {
        output = output.resolve("lorem-ipsum-out03.txt");

        List<String> lines = Files.readAllLines(input);
        lines.forEach(System.out::println);

        Files.write(output, lines);
    }
}
