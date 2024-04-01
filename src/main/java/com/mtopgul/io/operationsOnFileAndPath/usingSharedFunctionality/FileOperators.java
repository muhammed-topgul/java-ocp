package com.mtopgul.io.operationsOnFileAndPath.usingSharedFunctionality;

import com.mtopgul.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 17:38
 */
public class FileOperators {
    public static void main(String[] args) throws IOException {
        var file = new File("extras/ch14/text-folder/zoo.txt");
        var dir = new File("extras/ch14/text-folder");

        Util.divide("IO", 0);
        io(file);
        io(dir);

        Util.divide("NIO");

        var path = Path.of("extras/ch14/text-folder/zoo.txt");
        var dir1 = Path.of("extras/ch14/text-folder");
        nio(path);
        nio(dir1);
    }

    private static void nio(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("File Name: " + path.getFileName());
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Is File: " + Files.isRegularFile(path));
            System.out.println("Is Absolute Path: " + path.isAbsolute());
            System.out.println("Is Hidden: " + Files.isHidden(path));
            System.out.println("Parent Path: " + path.getParent());

            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            } else {
                Stream<Path> pathStream = Files.list(path);
                try (pathStream) {
                    pathStream.forEach(subFile -> System.out.println(" - " + subFile.getName(0)));
                }
            }
        }
        System.out.println();
    }

    private static void io(File file) {
        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Is File: " + file.isFile());
            System.out.println("Is Absolute Path: " + file.isAbsolute());
            System.out.println("Is Hidden: " + file.isHidden());
            System.out.println("Parent Path: " + file.getParent());

            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subFile : file.listFiles()) {
                    System.out.println(" - " + subFile.getName());
                }
            }
        }
        System.out.println();
    }
}
