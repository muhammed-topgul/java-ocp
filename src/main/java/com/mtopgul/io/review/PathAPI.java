package com.mtopgul.io.review;

import com.mtopgul.Util;

import java.nio.file.Path;

/**
 * Created by mtopgul on 31/10/2024 07:47
 */
public class PathAPI {
    public static void main(String[] args) {
        Util.divide("Name Count");
        {
            // Path nesnleri immutable'dır
            Path path = Path.of("whale");
            path.resolve("krill");
            System.out.println(path); // whale
        }

        {
            Path path = Path.of("C:\\data\\zoo.txt");
            System.out.println("Path: " + path);
            for (int i = 0; i < path.getNameCount(); i++) {
                System.out.println(" Name(" + i + ") " + path.getName(i));
            }
        }

        {
            Path path = Path.of("C:\\");
            for (int i = 0; i < path.getNameCount(); i++) {
                System.out.println(" Name(" + i + ") " + path.getName(i));
            }
        }

        {
            Path path1 = Path.of("../panther");
            Path path2 = Path.of("food");
            System.out.println(path1.resolve(path2));

            Path path3 = Path.of("/turkey/food");
            System.out.println(path3.resolve("/tiger/cage"));
        }
    }
}
