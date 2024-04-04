package com.mtopgul.io.workingWithAdvancedApis.discoveringFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 22:57
 */
public class CheckingForSymbolicLinks {
    public static void main(String[] args) throws IOException {
        Path newLink = Paths.get("extras/ch14/symbolic.txt");
        Path target = Path.of("extras/ch14/attributes.txt");

        Files.createFile(target);

        Files.createSymbolicLink(newLink, target);

        System.out.println(Files.isDirectory(Paths.get("extras/ch14")));                 // true
        System.out.println(Files.isSymbolicLink(Paths.get("extras/ch14/symbolic.txt"))); // true
        System.out.println(Files.isRegularFile(Path.of("extras/ch14/zoo.txt")));         // true

        Files.deleteIfExists(newLink);
        Files.deleteIfExists(target);
    }
}
