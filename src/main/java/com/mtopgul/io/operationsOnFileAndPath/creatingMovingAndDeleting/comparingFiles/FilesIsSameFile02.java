package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.comparingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 14:17
 */
public class FilesIsSameFile02 {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("extras/ch14");
        Path p2 = Paths.get("extras/../extras/ch14");

        System.out.println(p1.equals(p2));            // false
        System.out.println(Files.isSameFile(p1, p2)); // true
    }
}
