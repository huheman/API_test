package test03;

import java.sql.*;

public class JDBC_3 {
    public static void main(String[] args) throws SQLException {
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_temp", "root", "admin");

        //获取语句执行对象
        Statement statement = connection.createStatement();

        // 使用statement对象执行命令
        // 创建一个新的用户，叫user01，可以在任意ip地址登录
        String user01 = String.format("create user '%s'@'%s'", "user01","%");
        statement.execute(user01);

        //新增一行记录，周杰伦，存款是500，开户日期是2019年3月1日
        int i = statement.executeUpdate("insert into account (name,balance,create_date) values ('周杰伦',500,'2019-3-1');");
        System.out.println("i = " + i);

        //查询表
        ResultSet resultSet = statement.executeQuery("select * from account");
        System.out.println(resultSet);
    }
}
