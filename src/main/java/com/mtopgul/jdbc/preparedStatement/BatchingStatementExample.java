package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:04
 */
public class BatchingStatementExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();
        batchRegister(connection, 200, 1, "Jonas", "Adam");
    }

    private static void batchRegister(Connection connection, int firstKey, int foreignKey, String... names) throws SQLException {
        var sql = "INSERT INTO names VALUES (?, ?, ?);";
        var nextIndex = firstKey;

        try (var ps = connection.prepareStatement(sql)) {
            ps.setInt(2, foreignKey);
            for (String name : names) {
                ps.setInt(1, nextIndex++);
                ps.setString(3, name);
                ps.addBatch();
            }
            int[] result = ps.executeBatch();
            System.out.println(Arrays.toString(result));
        }
    }
}
