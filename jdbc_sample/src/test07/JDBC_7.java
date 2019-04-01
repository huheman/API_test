package test07;

import java.sql.*;

public class JDBC_7 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.executeUpdate("update account set balance = 3000 where id=1;");
            Savepoint savepoint = connection.setSavepoint();
            try {
                statement.executeUpdate("update account set balance = 2000 where id=1;");
                statement.executeUpdate("update account set balance = 1000 where id=1;");
                int b = 10 / 0;
                connection.commit();
            } catch (Exception e) {
                //任何错误都会导致回滚
                System.out.println("出错了！回滚");
                connection.rollback(savepoint);
                //connection.rollback();
                // 查看回滚后的数据
                showRS(statement.executeQuery("select * from account"));
            } finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("无法开启数据库");
        }
    }

    private static void showRS(ResultSet resultSet) {
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i + 1);
                    System.out.print(object + " , ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
