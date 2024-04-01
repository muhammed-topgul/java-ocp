package com.mtopgul.io.referencingFilesAndDirectories.creatingFileOrPath;

import java.io.File;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 13:35
 */
public class CreatingFile {
    public static void main(String[] args) {
        File f1 = new File("/home/tiger/data/stripes.txt");
        File f2 = new File("/home/tiger", "data/stripes.txt");

        File parent = new File("/home/tiger");
        File f3 = new File(parent, "data/stripes.txt");

        System.out.println(f1.exists());
        System.out.println(f2.exists());
        System.out.println(f3.exists());
    }
}
