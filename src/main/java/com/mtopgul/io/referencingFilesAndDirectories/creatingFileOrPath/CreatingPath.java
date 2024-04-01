package com.mtopgul.io.referencingFilesAndDirectories.creatingFileOrPath;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 17:06
 */
public class CreatingPath {
    public static void main(String[] args) {
        Path p1 = Path.of("/home/tiger/data/stripes.txt");
        Path p2 = Path.of("/home", "tiger", "data", "stripes.txt");

        Path p3 = Paths.get("/home/tiger/data/stripes.txt");
        Path p4 = Paths.get("/home", "tiger", "data", "stripes.txt");

        System.out.println(Files.exists(p1));
        System.out.println(p1.getClass());
        System.out.println(p2.getClass());
        System.out.println(p3.getClass());
        System.out.println(p4.getClass());
    }
}
