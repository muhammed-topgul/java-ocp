package com.mtopgul.jdbc.interfacesOfJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author muhammed-topgul
 * @since 15/04/2024 08:26
 */
public class SetupDatabase {
    public static void main(String[] args) throws SQLException {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/zoo_db";
        String username = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            dropExisting(connection);
            createTables(connection);
            createStoredProcedures(connection);

            printCount(connection, "SELECT count(*) FROM names");
        }
    }

    private static void dropExisting(Connection connection) throws SQLException {
        run(connection, "DROP PROCEDURE read_e_names IF EXISTING");
        run(connection, "DROP PROCEDURE read_e_names_by_letter IF EXISTING");
        run(connection, "DROP PROCEDURE magic_number IF EXISTING");
        run(connection, "DROP PROCEDURE double_number IF EXISTS");
        run(connection, "DROP TABLE names IF EXISTS");
        run(connection, "DROP TABLE exhibits IF EXISTS");
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
                CREATE PROCEDURE read_e_names()
                READS SQL DATA DYNAMIC RESULT SETS 1
                BEGIN ATOMIC
                DECLARE result CURSOR WITH RETURN FOR SELECT * FROM names WHERE LOWER(name) LIKE 'e%';
                OPEN result;
                END""";

        String inParam = """
                CREATE PROCEDURE read_names_by_letter(IN prefix VARCHAR(10))
                READS SQL DATA DYNAMIC RESULT SETS 1
                BEGIN ATOMIC
                DECLARE result CURSOR WITH RETURN FOR
                SELECT * FROM names WHERE LOWER(name) LIKE CONCAT(LOWER(prefix), '%');
                OPEN result;
                END""";

        String inOutParam = """
                CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA
                  DYNAMIC RESULT SETS 1
                  BEGIN ATOMIC 
                  SET num = num * 2; 
                  END""";

        String outParam = """
                CREATE PROCEDURE magic_number(OUT num INT) READS SQL DATA
                      BEGIN ATOMIC
                     SET num = 42;
                      END""";

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

    private static void printCount(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        try (preparedStatement; resultSet) {
            resultSet.next();
            System.out.println(resultSet.getInt(1));
        }
    }
}
