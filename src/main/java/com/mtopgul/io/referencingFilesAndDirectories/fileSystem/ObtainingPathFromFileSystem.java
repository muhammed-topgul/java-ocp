package com.mtopgul.io.referencingFilesAndDirectories.fileSystem;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 17:13
 */
public class ObtainingPathFromFileSystem {
    public static void main(String[] args) {
        Path p1 = FileSystems
                .getDefault()
                .getPath("/home/tiger/data/stripes.txt");
        Path p2 = FileSystems
                .getDefault()
                .getPath("/home", "tiger", "data", "stripes.txt");

        System.out.println(FileSystems.getDefault().getClass());
    }
}
