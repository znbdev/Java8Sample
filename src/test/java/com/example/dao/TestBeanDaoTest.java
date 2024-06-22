package com.example.dao;

import com.example.annotation.AnnotationValidator;
import com.example.bean.TestBean;
import com.example.config.TestDataSourceConfig;
import com.example.entity.TestBeanEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestBeanDaoTest {

    private DataSource dataSource;
    private TestBeanDao testBeanDao;
    private AnnotationValidator validator;

    @Before
    public void setUp() throws SQLException {
        try {
            dataSource = TestDataSourceConfig.getDataSource();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        testBeanDao = new TestBeanDao(dataSource);
        validator = new AnnotationValidator();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS test_bean");
        }
        testBeanDao.createTable();
    }

    @After
    public void tearDown() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS test_bean");
        }
    }

    @Test
    public void testInsertAndRetrieveTestBean() throws SQLException {
        TestBean bean = new TestBean("John Doe", "123 Main St", "A description", 25);
        testBeanDao.insertTestBean(bean);
        TestBeanEntity retrievedBean = testBeanDao.getTestBeanById(1);
        assertEquals(bean.getName(), retrievedBean.getName());
        assertEquals(bean.getAddress(), retrievedBean.getAddress());
        assertEquals(bean.getDescription(), retrievedBean.getDescription());
        assertEquals(bean.getAge(), retrievedBean.getAge());
    }

    @Test
    public void testInsertInvalidTestBean() {
        TestBean bean = new TestBean(null, "123 Main St", "Desc", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("name must not be null"));
    }

    @Test
    public void testRetrieveNonExistentTestBean() throws SQLException {
        TestBeanEntity retrievedBean = testBeanDao.getTestBeanById(999);
        assertNull(retrievedBean);
    }
}
