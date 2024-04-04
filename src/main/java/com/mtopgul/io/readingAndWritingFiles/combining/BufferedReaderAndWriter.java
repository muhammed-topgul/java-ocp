package com.mtopgul.io.readingAndWritingFiles.combining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 13:28
 */
public class BufferedReaderAndWriter {
    public static void main(String[] args) throws IOException {
        Path input = Path.of("extras/ch14/lorem-ipsum.txt");
        Path output = Path.of("extras/ch14/lorem-ipsum-out.txt");

        copyPath(input, output);
    }

    private static void copyPath(Path input, Path output) throws IOException {
        BufferedReader reader = Files.newBufferedReader(input);
        BufferedWriter writer = Files.newBufferedWriter(output);

        try (reader; writer) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.newLine();
        }
    }
}
