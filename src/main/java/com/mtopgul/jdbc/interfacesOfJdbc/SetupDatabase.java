package com.mtopgul.jdbc.interfacesOfJdbc;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 15/04/2024 08:26
 */
public class SetupDatabase {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = Util.getConnection()) {
            // Statement statement = connection.createStatement();
            dropExisting(connection);
            createTables(connection);
            createStoredProcedures(connection);
            printCount(connection);
        }
    }

    private static void dropExisting(Connection connection) throws SQLException {
        run(connection, "DROP PROCEDURE IF EXISTS read_e_names");
        run(connection, "DROP PROCEDURE IF EXISTS read_e_names_by_letter");
        run(connection, "DROP PROCEDURE IF EXISTS magic_number");
        run(connection, "DROP PROCEDURE IF EXISTS double_number");
        run(connection, "DROP TABLE IF EXISTS names");
        run(connection, "DROP TABLE IF EXISTS exhibits");
    }

    private static void createTables(Connection connection) throws SQLException {
        run(connection, """
                CREATE TABLE exhibits (
                  id INTEGER PRIMARY KEY,
                  name VARCHAR(255),
                  num_acres DECIMAL(4,1))""");

        run(connection, """
                CREATE TABLE names (
                   id INTEGER PRIMARY KEY,
                   species_id integer REFERENCES exhibits (id),
                   name VARCHAR(255))""");

        run(connection, "INSERT INTO exhibits VALUES (1, 'African Elephant', 7.5)");
        run(connection, "INSERT INTO exhibits VALUES (2, 'Zebra', 1.2)");

        run(connection, "INSERT INTO names VALUES (1, 1, 'Elsa')");
        run(connection, "INSERT INTO names VALUES (2, 2, 'Zelda')");
        run(connection, "INSERT INTO names VALUES (3, 1, 'Ester')");
        run(connection, "INSERT INTO names VALUES (4, 1, 'Eddie')");
        run(connection, "INSERT INTO names VALUES (5, 2, 'Zoe')");
    }

    private static void createStoredProcedures(Connection connection) throws SQLException {
        String noParams = """
                CREATE OR REPLACE FUNCTION read_e_names()
                RETURNS TABLE (id INT, name VARCHAR) AS $$
                BEGIN
                    RETURN QUERY SELECT id, name FROM names WHERE LOWER(name) LIKE 'e%';
                END;
                $$ LANGUAGE plpgsql;""";

        String inParam = """
                CREATE OR REPLACE FUNCTION read_names_by_letter(IN prefix VARCHAR(10))
                RETURNS TABLE (id INT, name VARCHAR) AS $$
                BEGIN
                    RETURN QUERY SELECT id, name FROM names WHERE LOWER(name) LIKE CONCAT(LOWER(prefix), '%');
                END;
                $$ LANGUAGE plpgsql;""";

        String inOutParam = """
                CREATE OR REPLACE FUNCTION double_number(INOUT num INT)
                RETURNS INT AS $$
                BEGIN
                    num := num * 2;
                END;
                $$ LANGUAGE plpgsql;""";

        String outParam = """
                CREATE OR REPLACE FUNCTION magic_number(OUT num INT)
                RETURNS INT AS $$
                BEGIN
                    num := 42;
                END;
                $$ LANGUAGE plpgsql;""";

        run(connection, noParams);
        run(connection, inParam);
        run(connection, outParam);
        run(connection, inOutParam);
    }

    private static void run(Connection connection, String sql) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        }
    }

    private static void printCount(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) FROM names");
        ResultSet resultSet = preparedStatement.executeQuery();
        try (preparedStatement; resultSet) {
            resultSet.next();
            System.out.println(resultSet.getInt(1));
        }
    }
}
