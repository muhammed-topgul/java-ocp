package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.copyingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:53
 */
public class FilesCopyIntoADirectory {
    public static void main(String[] args) throws IOException {
        var file = Paths.get("extras/ch14/food.txt");
        var dir = Paths.get("extras/ch14/enclosure/food.txt");

        Files.copy(file, dir);
    }
}
