package com.mtopgul.io.workingWithAdvancedApis.searchingDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

/**
 * @author muhammed-topgul
 * @since 05/04/2024 00:34
 */
public class SearchingDirectory {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        long minSize = 1000;
        BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> a.isRegularFile() && p.toString().endsWith(".java") && a.size() > minSize;
        Files.find(path, 10, predicate)
                .forEach(System.out::println);
    }
}
