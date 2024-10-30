package com.mtopgul.io.review;

import com.mtopgul.Util;

import java.io.File;
import java.nio.file.*;

/**
 * Created by mtopgul on 30/10/2024 23:26
 */
public class ReferencingFilesAndDirectories {
    public static void main(String[] args) {
        {
            Util.divide("Creating a File");
            File file1 = new File("C:\\ocp\\tiger\\data\\stripes.txt");
            File file2 = new File("C:\\ocp\\tiger", "data\\stripes.txt");
            File parent = new File("C:\\ocp");
            File file3 = new File(parent, "tiger\\data\\stripes.txt");

            System.out.println(file1.exists());  // true
            System.out.println(file2.exists());  // true
            System.out.println(parent.exists()); // true
            System.out.println(file3.exists());  // true
        }


        {
            Util.divide("Creating a Path");
            Path path1 = Path.of("C:\\ocp\\tiger\\data\\stripes.txt");
            Path path2 = Path.of("C:", "ocp", "tiger", "data", "stripes.txt");

            Path path3 = Paths.get("C:\\ocp\\tiger\\data\\stripes.txt");
            Path path4 = Paths.get("C:", "ocp", "tiger", "data", "stripes.txt");

            System.out.println(Files.exists(path1));
            System.out.println(Files.exists(path2));
            System.out.println(Files.exists(path3));
            System.out.println(Files.exists(path4));
        }

        {
            Util.divide("FileSystems Class");
            Path path1 = FileSystems.getDefault().getPath("C:\\ocp\\tiger\\data\\stripes.txt");
            Path path2 = FileSystems.getDefault().getPath("C:", "ocp", "tiger", "data", "stripes.txt");
            System.out.println(Files.exists(path1));
            System.out.println(Files.exists(path2));
        }

        {
            Util.divide("Switching Between Files and Directories");
            File file = new File("rabbit");
            Path path = file.toPath();
            File backToFile = path.toFile();

            System.out.println(path.getFileName());   // rabbit
            System.out.println(backToFile.getName()); // rabbit
        }

    }
}
