package com.mtopgul.jdbc.transactions;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * @author muhammed-topgul
 * @since 17/04/2024 19:36
 */
public class BookmarkingWithSavepointsExample01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getHsqlConnection();

        // Savepoint için auto commit mutlaka false almalı
        // connection.setAutoCommit(false);

        // Exception
        Savepoint savepoint = connection.setSavepoint();
    }
}
