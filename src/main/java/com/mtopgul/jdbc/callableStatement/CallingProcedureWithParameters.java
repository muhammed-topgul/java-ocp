package com.mtopgul.jdbc.callableStatement;

import com.mtopgul.Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:52
 */
public class CallingProcedureWithParameters {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();
        String sql = "{call read_names_by_letter(?)}";

        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString("prefix", "Z");
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
