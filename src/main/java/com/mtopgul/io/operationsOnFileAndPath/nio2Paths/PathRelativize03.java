package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:40
 */
public class PathRelativize03 {
    public static void main(String[] args) {
        // The relativize() method requires both paths to be absolute
        // or relative and throws an exception if the types are mixed.
        Path path1 = Paths.get("/primate/chimpanzee");
        Path path2 = Paths.get("/banana.txt");

        path1.relativize(path2); // IllegalArgumentException
    }
}
