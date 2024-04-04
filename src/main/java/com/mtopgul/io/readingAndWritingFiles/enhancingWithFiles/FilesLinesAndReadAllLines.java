package com.mtopgul.io.readingAndWritingFiles.enhancingWithFiles;

import com.mtopgul.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 13:21
 */
public class FilesLinesAndReadAllLines {
    public static void main(String[] args) throws IOException {
        Path input = Path.of("extras/ch14/lorem-ipsum.txt");

        Util.divide("readAllLines()");
        Files.readAllLines(input).forEach(System.out::println);

        Util.divide("lines()");
        Files.lines(input).forEach(System.out::println);
    }
}
