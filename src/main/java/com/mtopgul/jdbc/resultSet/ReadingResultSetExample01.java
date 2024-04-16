package com.mtopgul.jdbc.resultSet;

import com.mtopgul.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author muhammed-topgul
 * @since 16/04/2024 13:10
 */
public class ReadingResultSetExample01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();
        String sql = "SELECT id, name FROM exhibits";
        var idToNameMap = new HashMap<Integer, String>();

        try (var ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                idToNameMap.put(id, name);
            }
        }
        System.out.println(idToNameMap);
    }
}
