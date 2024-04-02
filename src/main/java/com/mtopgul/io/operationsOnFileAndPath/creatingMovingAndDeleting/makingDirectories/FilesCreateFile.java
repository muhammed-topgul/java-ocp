package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.makingDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:03
 */
public class FilesCreateFile {
    public static void main(String[] args) throws IOException {
        Files.createFile(Path.of("my-file"));
        Files.createFile(Paths.get("my-file2.properties"));
        Files.createFile(Paths.get("my-file3.xml"));

        Path dir = Files.createDirectory(Paths.get("my-folder"));
        Files.createFile(Path.of(dir.toString(), "text-file.txt"));
    }
}
