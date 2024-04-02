package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:24
 */
public class PathResolve01 {
    public static void main(String[] args) {
        Path path1 = Path.of("/cats/../panther");
        Path path2 = Path.of("food");
        System.out.println(path1.resolve(path2)); // \cats\..\panther\food
        System.out.println(path2.resolve(path1)); // \cats\..\panther

        Path path3 = Path.of("/turkey/food");
        Path path4 = Path.of("/tiger/cage");
        System.out.println(path3.resolve("/tiger/cage")); // \tiger\cage
        System.out.println(path3.resolve(path4));                // \tiger\cage
        System.out.println(path4.resolve(path3));                // \turkey\food
    }
}
