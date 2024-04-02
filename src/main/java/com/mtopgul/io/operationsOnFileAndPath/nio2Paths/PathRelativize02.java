package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 07:36
 */
public class PathRelativize02 {
    public static void main(String[] args) {
        Path path3 = Paths.get("E:\\habitat");
        Path path4 = Paths.get("E:\\sanctuary\\raven\\poe.txt");

        System.out.println(path3.relativize(path4)); // ..\sanctuary\raven\poe.txt
        System.out.println(path4.relativize(path3)); // ..\..\..\habitat
    }
}
