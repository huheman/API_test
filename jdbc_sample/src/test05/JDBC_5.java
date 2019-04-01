package test05;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class JDBC_5 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from account");
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.print(anInt + ",");
            String string = resultSet.getString(5);
            System.out.print("string = " + string + ",");
            byte[] bytes = resultSet.getBytes(5);
            System.out.print("bytes[] = ");
            for (byte aByte : bytes) {
                System.out.printf("%d ", aByte);
            }
            System.out.println();
        }
    }
}
