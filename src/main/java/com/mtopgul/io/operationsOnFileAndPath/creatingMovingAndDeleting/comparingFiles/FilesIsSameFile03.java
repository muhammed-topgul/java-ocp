package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.comparingFiles;

import com.mtopgul.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 14:21
 */
public class FilesIsSameFile03 {
    public static void main(String[] args) throws IOException {
        Path dir = Path.of("extras/ch14/animals");
        Path file1 = dir.resolve("file1.txt");
        Path file2 = dir.resolve("file2.txt");

        Util.createDir(dir);
        Util.createFile(file1);
        Util.createFile(file2);

        System.out.println(Files.isSameFile(file1, file2)); // false
        System.out.println(Files.isSameFile(file1, file1)); // true
    }
}
