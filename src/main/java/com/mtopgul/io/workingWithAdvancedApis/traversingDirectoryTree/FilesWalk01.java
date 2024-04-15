package com.mtopgul.io.workingWithAdvancedApis.traversingDirectoryTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 05/04/2024 00:25
 */
public class FilesWalk01 {
    public static void main(String[] args) throws IOException {
        try (var stream = Files.walk(Path.of("extras/ch14"))) {
            stream.forEach(System.out::println);
        }
    }
}
