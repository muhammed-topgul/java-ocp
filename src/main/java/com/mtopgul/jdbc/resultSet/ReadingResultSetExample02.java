package com.mtopgul.jdbc.resultSet;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:17
 */
public class ReadingResultSetExample02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();
        var sql = "SELECT count(*) as counter FROM exhibits";

        try (var ps = connection.prepareStatement(sql); var rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
            }
        }


        try (var ps = connection.prepareStatement(sql); var rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt("counter");
                System.out.println(count);
            }
        }
    }
}
