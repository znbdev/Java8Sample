package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class DataSourceConfig {

    public static DataSource getDataSource() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = DataSourceConfig.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);

        // 从配置文件中获取连接 URL
        String jdbcURL = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        log.info("jdbcURL: {}", jdbcURL);
        log.info("username: {}", username);
        log.info("password: {}", password);
        JdbcDataSource dataSource = new JdbcDataSource();
//        dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setURL(jdbcURL);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

