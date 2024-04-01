package com.mtopgul.io.referencingFilesAndDirectories.creatingFileOrPath;

import java.io.File;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 01/04/2024 17:12
 */
public class SwitchingBetweenFileAndPath {
    public static void main(String[] args) {
        File file = new File("rabbit");
        Path nowPath = file.toPath();
        File backToFile = nowPath.toFile();
    }
}
