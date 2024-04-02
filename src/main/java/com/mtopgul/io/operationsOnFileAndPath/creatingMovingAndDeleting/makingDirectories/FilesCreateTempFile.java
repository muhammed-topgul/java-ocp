package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.makingDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:10
 */
public class FilesCreateTempFile {
    public static void main(String[] args) throws IOException {
        Path tempFile1 = Files.createTempFile("tmp", null);
        System.out.println("File path: " + tempFile1.toAbsolutePath());

        Path tempFile2 = Files.createTempFile(Path.of("extras/ch14"), "tmp", ".txt");
        System.out.println("File path: " + tempFile2.toAbsolutePath());

        System.out.println(Files.deleteIfExists(tempFile1));
        System.out.println(Files.deleteIfExists(tempFile2));
    }
}
