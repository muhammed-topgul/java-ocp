package com.mtopgul.io.workingWithAdvancedApis.traversingDirectoryTree;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 05/04/2024 00:14
 */
public class DirectoryStreamExample {
    public static void main(String[] args) throws IOException {
        var dir = Paths.get("extras/ch14");

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
        try(directoryStream) {
            directoryStream.forEach(System.out::println);
        }
    }
}
