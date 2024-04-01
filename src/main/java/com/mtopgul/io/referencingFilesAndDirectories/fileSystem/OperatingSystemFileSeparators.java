package com.mtopgul.io.referencingFilesAndDirectories.fileSystem;

import java.nio.file.FileSystems;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 13:15
 */
public class OperatingSystemFileSeparators {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(FileSystems.getDefault().getSeparator());
    }
}
