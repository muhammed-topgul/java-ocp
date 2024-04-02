package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:28
 */
public class PathResolve02 {
    public static void main(String[] args) {
        Path path1 = Path.of("cats/../panther");
        Path path2 = Path.of("food");

        System.out.println(path1.resolve(path2)); // cats\..\panther\food
        System.out.println(path2.resolve(path1)); // food\cats\..\panther
    }
}
