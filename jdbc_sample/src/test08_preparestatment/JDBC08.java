package test08_preparestatment;


import test07.JDBC_7;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC08 {
    public static void main(String[] args) {
        //testSelect();
        //testUpdate();
        //testDelete();
        //testInsert();
        testInsert();
    }

    private static void testInsert() {
        String sql = "INSERT INTO account (name,balance,create_date,cost) values(?,?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            try {
                pstm.setObject(1, "黎明");
                pstm.setObject(2, 300);
                pstm.setObject(3, "2018-06-20");
                pstm.setObject(4,30.0);
                pstm.executeUpdate();
                testSelect();
            }finally {
                JDBCUtil.close(connection,pstm);
            }
        } catch (SQLException e) {
            System.out.println("无法创建连接");
        }
    }

    private static void testDelete() {
        String sql = "delete from account where id=?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            try {
                pstmt.setObject(1, 1);
                System.out.println("pstmt.executeUpdate() = " + pstmt.executeUpdate());
                pstmt.clearParameters();
                testSelect();
            }finally {
                JDBCUtil.close(connection,pstmt);
            }
        } catch (SQLException e) {
            System.out.println("无法创建连接");
        }
    }

    private static void testUpdate() {
        String sql = "UPDATE account Set balance = ? where id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            try {
                pstmt.setObject(1, 1000);
                pstmt.setObject(2, 1);
                int i = pstmt.executeUpdate();
                System.out.println("i = " + i);
                //testSelect();
            } finally {
                JDBCUtil.close(connection, pstmt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
    }

    private static void testSelect() {
        String sql = "select * from account ";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            try {
                //pstmt.setObject(1, 10);
                ResultSet resultSet = pstmt.executeQuery();
                JDBC_7.showRS(resultSet);
            } finally {
                JDBCUtil.close(connection, pstmt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
