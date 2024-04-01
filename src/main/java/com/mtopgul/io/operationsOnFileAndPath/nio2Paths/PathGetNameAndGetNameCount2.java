package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 23:14
 */
public class PathGetNameAndGetNameCount2 {
    public static void main(String[] args) {
        var path = Path.of("/");
        System.out.println(path.getNameCount());    // 0
        System.out.println(path.getFileName());     // null
        System.out.println(path.getName(0)); // IllegalArgumentException
    }
}
