package com.mtopgul.jdbc.connectingToDb;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 07:34
 */
public class TestConnect {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = Util.getConnection()) {
            System.out.println(connection);
        }
    }
}
