package com.mtopgul.jdbc.interfacesOfJdbc;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 07:18
 */
public class MyFirstDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM exhibits");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
    }
}
