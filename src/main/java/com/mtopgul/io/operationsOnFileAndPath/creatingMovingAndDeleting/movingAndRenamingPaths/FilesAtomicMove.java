package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.movingAndRenamingPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 13:36
 */
public class FilesAtomicMove {
    public static void main(String[] args) throws IOException {
        Files.move(Path.of("extras/ch14/mouse.txt"), Path.of("extras/ch14/gerbil.txt"), StandardCopyOption.ATOMIC_MOVE);
    }
}
