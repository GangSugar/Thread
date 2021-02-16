package com.zg;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库获取连接采用单例模式——懒汉模式
 */

public class DBUtil {
    private static volatile DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        if (dataSource == null){
            synchronized (DBUtil.class){
                if (dataSource == null){
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();

                    mysqlDataSource.setServerName("localhost");
                    mysqlDataSource.setPort(3306);

                    dataSource = mysqlDataSource;
                }
            }
        }
        return dataSource.getConnection();
    }

}

