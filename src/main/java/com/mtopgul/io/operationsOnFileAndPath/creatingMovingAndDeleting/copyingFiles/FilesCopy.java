package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.copyingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 09:24
 */
public class FilesCopy {
    public static void main(String[] args) throws IOException {
        // Copies file
        Files.copy(Paths.get("extras/ch14/panda/bamboo.txt"), Paths.get("extras/ch14/panda-save/bamboo.txt"));

        // Copies (Shallow) directory
        Files.copy(Paths.get("extras/ch14/turtle"), Paths.get("extras/ch14/turtleCopy"));
    }
}
