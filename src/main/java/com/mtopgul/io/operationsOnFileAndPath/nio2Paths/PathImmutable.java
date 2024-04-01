package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 23:08
 */
public class PathImmutable {
    public static void main(String[] args) {
        Path path1 = Path.of("whale");
        path1.resolve("krill");

        System.out.println(path1); // whale

        Path path2 = Path.of("/zoo/../home").getParent().normalize().toAbsolutePath();
        System.out.println(path2);
    }
}
