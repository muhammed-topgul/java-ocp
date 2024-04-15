package com.mtopgul.io.workingWithAdvancedApis.discoveringFileAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 23:10
 */
public class RetrievingAttributes {
    public static void main(String[] args) throws IOException {
        var path = Path.of("extras/ch14/zoo.txt");

        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("Is a directory: " + attributes.isDirectory());
        System.out.println("Is a regular file: " + attributes.isRegularFile());
        System.out.println("Is a symbolic link: " + attributes.isSymbolicLink());
        System.out.println("Size (in  bytes): " + attributes.size());
        System.out.println("Creation time: " + attributes.creationTime());
        System.out.println("Last access time: " + attributes.lastAccessTime());
        System.out.println("Last modified time: " + attributes.lastModifiedTime());

        DosFileAttributes dosAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("Is system: " + dosAttributes.isSystem());
    }
}
