package com.mtopgul.io.workingWithAdvancedApis.discoveringFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 23:03
 */
public class CheckingFileAccessibility {
    public static void main(String[] args) {
        Path zooTxt = Paths.get("extras/ch14/zoo.txt");

        try {
            System.out.println(Files.isHidden(zooTxt)); // false
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Files.isReadable(zooTxt));    // true
        System.out.println(Files.isWritable(zooTxt));    // true
        System.out.println(Files.isExecutable(zooTxt));  // true
    }
}
