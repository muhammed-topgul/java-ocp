package com.mtopgul.jdbc.callableStatement;

import com.mtopgul.Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:36
 */
public class CallingProcedureWithoutParameters {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();
        String sql = "{call read_e_names()}";

        try (CallableStatement cs = connection.prepareCall(sql)) {
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
