package test09_datasource.c3p0_test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import test07.JDBC_7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC09 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection connection = ds.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("select * from account");
        ResultSet resultSet = pstmt.executeQuery();
        JDBC_7.showRS(resultSet);
    }
}
