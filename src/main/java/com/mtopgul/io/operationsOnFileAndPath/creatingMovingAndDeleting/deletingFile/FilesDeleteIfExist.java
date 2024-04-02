package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.deletingFile;

import com.mtopgul.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 13:57
 */
public class FilesDeleteIfExist {
    public static void main(String[] args) throws IOException {
        // Util.createDir("extras/ch14/pigeon");
        boolean delete1 = Files.deleteIfExists(Path.of("extras/ch14/pigeon"));
        boolean delete2 = Files.deleteIfExists(Path.of("extras/ch14/pigeon"));

        System.out.println(delete1); // true
        System.out.println(delete2); // false
    }
}
