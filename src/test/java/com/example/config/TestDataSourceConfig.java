package com.example.config;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataSourceConfig {

    public static DataSource getDataSource() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = TestDataSourceConfig.class.getClassLoader().getResourceAsStream("application-test.properties");
        properties.load(inputStream);

        // 从配置文件中获取连接 URL
        String jdbcURL = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        System.out.println("jdbcURL: " + jdbcURL);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        JdbcDataSource dataSource = new JdbcDataSource();
//        dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setURL(jdbcURL);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

