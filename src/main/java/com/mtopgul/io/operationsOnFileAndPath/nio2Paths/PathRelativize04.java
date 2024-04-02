package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:43
 */
public class PathRelativize04 {
    public static void main(String[] args) {
        // On Windows-based systems, it also requires that if absolute paths are used,
        // both paths must have the same root directory or drive letter.
        var path3 = Paths.get("C:\\primate\\chimpanzee");
        var path4 = Paths.get("D:\\storage\\bananas.txt");

        path3.relativize(path4); // IllegalArgumentException
    }
}
