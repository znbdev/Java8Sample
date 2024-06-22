package com.example.db.h2;

import com.example.config.DataSourceConfig;
import com.example.dao.TestBeanDao;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class H2DatabaseOriginator {

    public static void main(String[] args) throws SQLException, IOException {
        DataSource dataSource = DataSourceConfig.getDataSource();
        TestBeanDao testBeanDao = new TestBeanDao(dataSource);
        testBeanDao.createTable();
    }

}
