package test10_jdbctemplate;

import javabean.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTemplateTest {
    private static JdbcTemplate template = null;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static {
        try {
            template = new JdbcTemplate(DataSourceUtil.getDataSource());
            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DataSourceUtil.getDataSource());
        } catch (Exception e) {
            System.out.println("初始化失败！");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //testInsert();
        //testDelete();
        //testUpdate();
        //testQueryForObject();
        // testQueryForMap();
        //testQuery();
        //testQuery_2();
        //testInsertMap();
        //testInsertObject();
        testNamedQuery();
    }

    private static void testNamedQuery() {
        String sql = "select name ,balance,create_date from account where name =:name";
        Account account = new Account();
        account.setName("黎明");
        List<Account> accountList = namedParameterJdbcTemplate.query(sql,
                new BeanPropertySqlParameterSource(account),
                new BeanPropertyRowMapper<>(Account.class));
        for (Account accoutnInList : accountList) {
            System.out.println(accoutnInList);
        }
    }

    private static void testInsertObject() {
        String sql = "update account set balance = :balance where name = :name ";
        Account account = new Account();
        account.setBalance(300);
        account.setName("黎明");
        SqlParameterSource bpsps = new BeanPropertySqlParameterSource(account);
        namedParameterJdbcTemplate.update(sql, bpsps);
    }

    private static void testInsertMap() {
        String sql = "update account set balance = :newBalance where name = :name ";
        Map<String, Object> map = new HashMap<>();
        map.put("newBalance", 2000);
        map.put("name", "黎明");
        namedParameterJdbcTemplate.update(sql, map);
    }

    private static void testQuery_2() {
        List<Account> accountList = template.query("select * from account where id < ? ",
                new BeanPropertyRowMapper<>(Account.class), 14);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    private static void testQuery() {
        List<Account> accountList = template.query("select * from account where id < ?", (rs, rowNum) -> {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Account account = null;
            try {
                account = Account.class.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    Field declaredField = Account.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    Object object = rs.getObject(i + 1);
                    declaredField.set(account, object);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return account;
        }, 5);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    private static void testQueryForMap() {
        List<Map<String, Object>> mapList = template.queryForList("select id 编码 , name 姓名 from account", new Object[]{});
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }

    private static void testQueryForObject() {
        Double o = template.queryForObject("select avg(balance) from account", Double.class);
        System.out.println("o = " + o);
    }

    private static void testUpdate() {
        String sql = "Update account set balance =? where id=?";
        int update = template.update(sql, 500, 18);
        System.out.println("update = " + update);
    }

    private static void testDelete() {
        String sql = "DELETE from account where name  = ?";
        int i = template.update(sql, "周润发");
        System.out.println("i = " + i);
    }

    private static void testInsert() {
        String sql = "INSERT INTO account (name,balance,create_date,cost) VALUES (?,?,?,?)";
        int i = template.update(sql, "周润发", 500, "2014-09-20", 24.5);
        System.out.println("i = " + i);
    }
}
