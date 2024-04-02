package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.makingDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 08:53
 */
public class FilesCreateDirectory {
    public static void main(String[] args) throws IOException {
        Files.createDirectory(Path.of("bison"));
        Files.createDirectory(Path.of("bison/field"));

        // FileAlreadyExistException: bison
        Files.createDirectory(Path.of("bison"));

        // NoSuchFileException: parent\child
        Files.createDirectory(Path.of("parent/child"));
    }
}
