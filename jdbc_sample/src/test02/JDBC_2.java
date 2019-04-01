package test02;

import java.sql.*;

public class JDBC_2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
        Statement statement = connection.createStatement();
        System.out.println("statement = " + statement);

        ResultSet resultSet = statement.executeQuery("select * from account");
        while (resultSet.next()) {
            ResultSetMetaData md = resultSet.getMetaData();
            for (int i = 0; i < md.getColumnCount(); i++) {
                String columnClassName = md.getColumnClassName(i + 1);
                System.out.print(columnClassName+",");
            }
            System.out.println();
        }
    }

}
