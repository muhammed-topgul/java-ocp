package com.mtopgul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:20
 */
public final class Util {

    private static final String hsqlUrl = "jdbc:hsqldb:file:zoo_db"; /*"jdbc:postgresql://localhost:5432/zoo_db";*/
    private static final String pglUrl = "jdbc:postgresql://localhost:5432/zoo_db";
    private static final String username = "postgres";
    private static final String password = "postgres";

    private Util() {
    }

    public static void divide() {
        System.out.println("\n-------------------");
    }

    public static void divide(String title) {
        divide(title, 1);
    }

    public static void divide(String title, int newLineCount) {
        System.out.println("\n".repeat(newLineCount) + "----------" + title + "----------");
    }

    public static void createFile(Path path) throws IOException {
        createFile(path.toString());
    }

    public static void createFile(String fileName) throws IOException {
        Path filePath = Path.of(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    public static void createFile(String directory, String fileName) throws IOException {
        Path filePath = createDir(directory).resolve(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    public static Path createDir(Path directory) throws IOException {
        return createDir(directory.toString());
    }

    public static Path createDir(String directory) throws IOException {
        Path dir = Path.of(directory);
        if (!Files.exists(dir)) {
            return Files.createDirectory(dir);
        }
        return dir;
    }

    public static Connection getHsqlConnection() throws SQLException {
        return getConnection(hsqlUrl);
    }

    public static Connection getPgConnection() throws SQLException {
        return getConnection(pglUrl);
    }

    public static Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Day of Year = " + today.getDayOfYear());

        int weekOfYear = today.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
        System.out.println("Week of Year = " + weekOfYear);
    }
}
