package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 08:03
 */
public class PathToRealPath {
    public static void main(String[] args) throws IOException {
        System.out.println(Paths.get(".").toRealPath());
        System.out.println(Paths.get("extras/ch14/zoo.txt").toRealPath());
        System.out.println(Paths.get("extras/ch14/food.txt").toRealPath());

        // NoSuchFileException
        System.out.println(Paths.get("extras/ch14/missing.txt").toRealPath());
    }
}
