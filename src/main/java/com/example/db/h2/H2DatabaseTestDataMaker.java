package com.example.db.h2;

import com.example.bean.TestBean;
import com.example.config.DataSourceConfig;
import com.example.dao.TestBeanDao;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class H2DatabaseTestDataMaker {

    public static void main(String[] args) throws SQLException, IOException {
        DataSource dataSource = DataSourceConfig.getDataSource();
        createTestBeanData(dataSource);
    }

    static void createTestBeanData(DataSource dataSource) throws SQLException {
        TestBeanDao testBeanDao = new TestBeanDao(dataSource);
        TestBean bean = new TestBean("John Doe", "123 Main St", "A description", 25);
        testBeanDao.insertTestBean(bean);
    }
}
