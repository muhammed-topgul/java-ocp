package com.mtopgul.io.operationsOnFileAndPath.nio2Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 23:12
 */
public class PathGetNameAndGetNameCount1 {
    public static void main(String[] args) {
        Path path = Paths.get("/land/hippo/harry.happy");
        System.out.println("Path Name: " + path);
        System.out.println("File Name: " + path.getFileName());

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(" Element " + i + " is: " + path.getName(i));
        }
    }
}
