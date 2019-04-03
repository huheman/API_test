package test10_jdbctemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {
    private static DataSource ds = null;

    public static DataSource getDataSource() throws Exception {
        if (ds == null) {
            synchronized (DataSourceUtil.class) {
                if (ds == null) {
                    Properties pp = new Properties();
                    pp.load(DataSourceUtil.class.getResourceAsStream("/druid.properties"));
                    ds = DruidDataSourceFactory.createDataSource(pp);
                }
            }
        }
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
