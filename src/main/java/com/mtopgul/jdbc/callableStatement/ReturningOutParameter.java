package com.mtopgul.jdbc.callableStatement;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author muhammed-topgul
 * @since 17/04/2024 16:34
 */
public class ReturningOutParameter {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();

        var sql = "{?= call magic_number(?)}";
        try(var cs = connection.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();

            System.out.println(cs.getInt("num"));
            System.out.println(cs.getInt(1));
        }
    }
}
