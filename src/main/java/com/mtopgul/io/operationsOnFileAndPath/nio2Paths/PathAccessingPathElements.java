package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 23:44
 */
public class PathAccessingPathElements {
    public static void main(String[] args) {
        printPathInformation(Path.of("zoo"));
        printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
        printPathInformation(Path.of("/zoo/armadillo/../shells.txt"));
    }

    private static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println(" Current parent is: " + currentPath);
        }
        System.out.println();
    }
}
