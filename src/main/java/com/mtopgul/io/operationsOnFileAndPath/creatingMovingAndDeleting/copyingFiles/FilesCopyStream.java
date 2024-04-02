package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.copyingFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:45
 */
public class FilesCopyStream {
    public static void main(String[] args) throws IOException {
        try(var is = new FileInputStream("extras/ch14/source-data.txt")) {
            Files.copy(is, Path.of("extras/ch14/wolf.txt"));
        }

        Files.copy(Paths.get("extras/ch14/clown.txt"), System.out);
    }
}
