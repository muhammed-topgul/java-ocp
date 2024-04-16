package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 08:24
 */
public class ProcessingDataWithExecuteExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();

        execute(connection, "SELECT * FROM exhibits");
        execute(connection, "UPDATE exhibits SET name = '' " + "WHERE name = 'None'");

    }

    private static void execute(Connection connection, String selectSql) throws SQLException {
        try(var ps = connection.prepareStatement(selectSql)) {
            boolean isSelect = ps.execute();
            if (isSelect) {
                ResultSet resultSet = ps.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    System.out.println(id + " " + name);
                }
            } else {
                int affectedRows = ps.getUpdateCount();
                System.out.println(affectedRows + " rows affected.");
            }
        }
    }
}
