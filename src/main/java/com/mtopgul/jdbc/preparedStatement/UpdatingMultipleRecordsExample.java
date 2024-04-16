package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 12:54
 */
public class UpdatingMultipleRecordsExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();

        var sql = "INSERT INTO names VALUES (?, ?, ?);";

        try (var ps = connection.prepareStatement(sql)) {
            ps.setInt(1, 20);
            ps.setInt(2, 1);
            ps.setString(3, "Evan");

            ps.executeUpdate();

            ps.setInt(1, 21);
            ps.setString(3, "Elias");
            ps.executeUpdate();
        }

        try (var ps = connection.prepareStatement("SELECT * FROM names;")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int type = resultSet.getInt(2);
                String name = resultSet.getString(3);
                System.out.println(id + ", " + type + ", " + name);
            }
        }
    }
}
