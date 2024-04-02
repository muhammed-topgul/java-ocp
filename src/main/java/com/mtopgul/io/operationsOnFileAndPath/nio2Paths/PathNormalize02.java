package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:56
 */
public class PathNormalize02 {
    public static void main(String[] args) {
        var path1 = Paths.get("/pony/../weather.txt");
        var path2 = Paths.get("/weather.txt");

        System.out.println(path1.equals(path2));             // false
        System.out.println(path1.normalize().equals(path2)); // true
    }
}
