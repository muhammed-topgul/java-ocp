package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:33
 */
public class PathRelativize01 {
    public static void main(String[] args) {
        var path1 = Path.of("fish.txt");
        var path2 = Path.of("friendly/birds.txt");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));

        System.out.println(path1.relativize(path1));
    }
}
