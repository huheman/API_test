package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_1 {
    public static void main(String[] args) throws SQLException {
        // 获取连接
        Connection conn_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
        System.out.println("conn_2 = " + conn_2);
        // 自己把用户名和密码放进url中
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp?user=root&password=admin");
        System.out.println("connection = " + connection);
    }
}
