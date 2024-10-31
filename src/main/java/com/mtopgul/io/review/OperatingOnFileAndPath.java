package com.mtopgul.io.review;

import com.mtopgul.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by mtopgul on 30/10/2024 23:42
 */
public class OperatingOnFileAndPath {
    public static void main(String[] args) throws IOException {
        {
            file("C:\\data\\zoo.txt");
            file("C:\\data");
            file("C:\\");

            Util.divide();

            path("C:\\data\\zoo.txt");
            path("C:\\data");
            path("C:\\");
        }
    }

    private static void file(String pathname) {
        var file = new File(pathname);
        if (file.exists()) {
            Util.divide(file.getAbsolutePath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Absolute: " + file.isAbsolute());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                File[] files = file.listFiles();
                for (File subFile : files) {
                    System.out.println("    > " + subFile.getName());
                }
            }
        }
    }

    private static void path(String pathname) throws IOException {
        var path = Path.of(pathname);
        if (Files.exists(path)) {
            Util.divide("" + path.toAbsolutePath());
            System.out.println("Is Absolute: " + path.isAbsolute());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            } else {
                try(Stream<Path> paths = Files.list(path)) {
                    paths.forEach(p -> System.out.println("     > " + p.getFileName()));
                }
            }
        }
    }
}
