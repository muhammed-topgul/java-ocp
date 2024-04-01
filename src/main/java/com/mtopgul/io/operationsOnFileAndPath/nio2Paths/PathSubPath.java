package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 23:36
 */
public class PathSubPath {
    public static void main(String[] args) {
        var path = Paths.get("/mammal/omnivore/raccoon.image");
        System.out.println("Path is: " + path);

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(" Element " + i + " is: " + path.getName(i));
        }

        System.out.println();

        System.out.println("subpath(0, 3): " + path.subpath(0, 3)); // mammal\omnivore\raccoon.image
        System.out.println("subpath(1, 2): " + path.subpath(1, 2)); // omnivore
        System.out.println("subpath(1, 3): " + path.subpath(1, 3)); // omnivore\raccoon.image

        var q = path.subpath(0, 4); // IllegalArgumentException
        var x = path.subpath(1, 1); // IllegalArgumentException
    }
}
