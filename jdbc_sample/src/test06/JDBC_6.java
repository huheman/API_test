package test06;

import java.sql.*;

public class JDBC_6 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from account");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            System.out.println("row in " + (i + 1));
            int columnDisplaySize = metaData.getColumnDisplaySize(i + 1);
            System.out.println("columnDisplaySize = " + columnDisplaySize);
            String catalogName = metaData.getCatalogName(i + 1);
            System.out.println("catalogName = " + catalogName);
            String columnClassName = metaData.getColumnClassName(i + 1);
            System.out.println("columnClassName = " + columnClassName);
            String columnLabel = metaData.getColumnLabel(i + 1);
            System.out.println("columnLabel = " + columnLabel);
            String columnName = metaData.getColumnName(i + 1);
            System.out.println("columnName = " + columnName);
            String columnTypeName = metaData.getColumnTypeName(i + 1);
            System.out.println("columnTypeName = " + columnTypeName);
            int columnType = metaData.getColumnType(i + 1);
            System.out.println("columnType = " + columnType);
            String tableName = metaData.getTableName(i + 1);
            System.out.println("tableName = " + tableName);
            System.out.println("------------------------");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
