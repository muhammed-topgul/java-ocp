package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:53
 */
public class PathNormalize01 {
    public static void main(String[] args) {
        var path1 = Path.of("./armadillo/../shells.txt");
        System.out.println(path1.normalize()); // shells.txt

        var path2 = Path.of("/cats/../panther/food");
        System.out.println(path2.normalize()); // \panther\food

        var path3 = Path.of("../../fish.txt");
        System.out.println(path3.normalize()); // ..\..\fish.txt
    }
}
