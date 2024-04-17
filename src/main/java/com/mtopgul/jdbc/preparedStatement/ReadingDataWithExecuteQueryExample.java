package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 08:01
 */
public class ReadingDataWithExecuteQueryExample {
    public static void main(String[] args) throws SQLException {
        var sql = "SELECT * FROM exhibits";

        Connection connection = Util.getHsqlConnection();
        try (var ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        }
    }
}
