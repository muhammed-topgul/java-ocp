package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.comparingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 14:27
 */
public class FilesMismatch {
    public static void main(String[] args) throws IOException {
        Path basePath = Path.of("extras/ch14/animals");
        Path monkeyPath = basePath.resolve("monkey.txt");
        Path wolfPath = basePath.resolve("wolf.txt");

        System.out.println(Files.mismatch(monkeyPath, wolfPath)); // Positive number
        System.out.println(Files.mismatch(wolfPath, monkeyPath)); // Positive number
        System.out.println(Files.mismatch(wolfPath, wolfPath));   // -1
    }
}
