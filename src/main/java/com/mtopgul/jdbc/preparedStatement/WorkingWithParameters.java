package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 08:32
 */
public class WorkingWithParameters {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();

        register(connection);
        register(connection, 100, 1, "Admin");
    }

    private static void register(Connection connection) throws SQLException {
        try (var ps = connection.prepareStatement("INSERT INTO names VALUES (6, 1, 'John')")) {
            ps.executeUpdate();
        }
    }

    private static void register(Connection connection, int key, int foreignKey, String name) throws SQLException {
        String sql = "INSERT INTO names VALUES (?, ?, ?)";
        try (var ps = connection.prepareStatement(sql)) {
            ps.setInt(1, key);
            ps.setInt(2, foreignKey);
            ps.setString(3, name);

            ps.executeUpdate();
        }
    }
}
