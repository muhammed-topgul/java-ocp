package com.mtopgul.jdbc.transactions;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author muhammed-topgul
 * @since 17/04/2024 18:54
 */
public class NoTransactionExample {
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE_V1 (NAME, SALARY, CREATED_DATE) VALUES (?, ?, ?);";
    private static final String SQL_CREATE_TABLE = """
            CREATE TABLE EMPLOYEE_V1 (
              ID Serial,
              NAME VARCHAR(255) NOT NULL,
              SALARY numeric(15, 2) NOT NULL,
              CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
              PRIMARY KEY (ID)
            )
            """;
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS EMPLOYEE_V1";

    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getPgConnection();
        Statement stt = connection.createStatement();
        PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

        try(connection; stt; psInsert) {
            stt.execute(SQL_DROP_TABLE);
            stt.execute(SQL_CREATE_TABLE);

            psInsert.setString(1, "Emp-1");
            psInsert.setInt(2, 100);
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Emp-2");
            psInsert.setInt(2, 200);
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(2, "Emp-3");
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
        }
    }
}
