package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/db_temp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
