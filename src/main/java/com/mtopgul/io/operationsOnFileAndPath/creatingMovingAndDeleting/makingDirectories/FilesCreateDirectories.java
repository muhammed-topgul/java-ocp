package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.makingDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 08:57
 */
public class FilesCreateDirectories {
    public static void main(String[] args) throws IOException {
        Files.createDirectories(Path.of("bison/field/pasture/green"));

        Files.createDirectories(Path.of("parent/child"));
        Files.createDirectories(Path.of("parent/child"));
    }
}
