package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.movingAndRenamingPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 10:24
 */
public class FilesMove01 {
    public static void main(String[] args) throws IOException {
        // Renames
        Files.move(Path.of("extras/ch14/zoo1.txt"), Path.of("extras/ch14/zoo1-new.txt"));

        // Renames
        Files.move(Path.of("extras/ch14/move-dir"), Path.of("extras/ch14/move-dir-new"));
    }
}
