package com.mtopgul.io.workingWithAdvancedApis.traversingDirectoryTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author muhammed-topgul
 * @since 05/04/2024 00:20
 */
public class WalkingDirectory {
    public static void main(String[] args) throws IOException {
        var walker = new WalkingDirectory();
        long pathSize = walker.getPathSize(Path.of("."));

        System.out.printf("Total size: %.2f mb: ", (pathSize / 1000000.0));
    }

    private long getSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0;
        }
    }

    private long getPathSize(Path source) throws IOException {
        try (var stream = Files.walk(source)) {
            return stream.parallel()
                    .filter(p -> !Files.isDirectory(p))
                    .mapToLong(this::getSize)
                    .sum();
        }
    }
}
