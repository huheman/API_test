package test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_4 {
    public static void main(String[] args) throws SQLException {
        Connection conn_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
        Statement stm_1 = conn_1.createStatement();
        Statement stm_2 = conn_1.createStatement();
        System.out.println("stm_1 = " + stm_1);
        System.out.println("stm_2 = " + stm_2);
    }
}
