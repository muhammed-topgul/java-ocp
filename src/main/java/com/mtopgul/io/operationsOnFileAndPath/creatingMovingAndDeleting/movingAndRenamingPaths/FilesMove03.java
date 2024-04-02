package com.mtopgul.io.operationsOnFileAndPath.creatingMovingAndDeleting.movingAndRenamingPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 02/04/2024 11:07
 */
public class FilesMove03 {
    public static void main(String[] args) throws IOException {
        // Renames reports.xml -> report-xml
        Files.move(Path.of("extras/ch14/reports.xml"), Path.of("extras/ch14/reports-xml"));
    }
}
