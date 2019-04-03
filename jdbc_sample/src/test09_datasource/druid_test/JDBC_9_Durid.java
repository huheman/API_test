package test09_datasource.druid_test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import test07.JDBC_7;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC_9_Durid {
    public static void main(String[] args) throws Exception {
        Properties pp = new Properties();
        pp.load(JDBC_9_Durid.class.getResourceAsStream("/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pp);
        Connection connection = dataSource.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select  * from account");
        ResultSet resultSet = pstm.executeQuery();
        JDBC_7.showRS(resultSet);
    }
}
