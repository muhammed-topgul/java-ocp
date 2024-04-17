package com.mtopgul.jdbc.preparedStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 07:54
 */
public class ModifyingDataWithExecuteUpdateExample {
    public static void main(String[] args) throws SQLException {
        var insertSql = "INSERT INTO exhibits VALUES(10, 'Deer', 3)";
        var updateSql = "UPDATE exhibits SET name = '' " + "WHERE name = 'None'";
        var deleteSql = "DELETE FROM exhibits WHERE id = 10";

        Connection connection = Util.getHsqlConnection();

        try(PreparedStatement ps = connection.prepareStatement(insertSql)) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected); // 1
        }

        try(var ps = connection.prepareStatement(updateSql)) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected); // 0
        }

        try(var ps = connection.prepareStatement(deleteSql)) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected); // 1
        }
    }
}
