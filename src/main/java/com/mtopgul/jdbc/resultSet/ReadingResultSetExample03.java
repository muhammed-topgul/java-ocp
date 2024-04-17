package com.mtopgul.jdbc.resultSet;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:23
 */
public class ReadingResultSetExample03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();
        var sql = "SELECT count(*) FROM exhibits";

        try (var ps = connection.prepareStatement(sql); var rs = ps.executeQuery()) {
            // rs.next();
            int count = rs.getInt(1); // SQLException
            System.out.println(count);
        }
    }
}
