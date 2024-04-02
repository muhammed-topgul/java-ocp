package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:57
 */
public class PathNormalize03 {
    public static void main(String[] args) {
        var p1 = Path.of("./dir");
        var p2 = Path.of("../dir");
        var p3 = Path.of("parent/../dir");
        var p4 = Path.of("../parent/../dir");

        System.out.println(p1.normalize()); // dir
        System.out.println(p2.normalize()); // ../dir
        System.out.println(p3.normalize()); // dir
        System.out.println(p4.normalize()); // ../dir
    }
}
