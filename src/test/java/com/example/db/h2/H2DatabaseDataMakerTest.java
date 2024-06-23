package com.example.db.h2;

import com.example.bean.TestBean;
import com.example.dao.TestBeanDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class H2DatabaseDataMakerTest {

    @Mock
    private DataSource mockDataSource;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private TestBeanDao mockTestBeanDao;

    @Before
    public void setup() throws SQLException {
        MockitoAnnotations.initMocks(this);

        // Mock the behavior of DataSource methods
        when(mockDataSource.getConnection()).thenReturn(mockConnection);

        // Mock the behavior of Connection methods
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);

        // Initialize your mockTestBeanDao with the mockDataSource
        mockTestBeanDao = new TestBeanDao(mockDataSource);
    }

    @Test
    public void testCreateTestBeanData() throws SQLException {
        // Prepare a test bean
        TestBean testBean = new TestBean("John Doe", "123 Main St", "A description", 25);

        // Call the method under test
        mockTestBeanDao.insertTestBean(testBean);

        // Verify that PreparedStatement methods were called with the correct parameters
        verify(mockPreparedStatement, times(1)).setString(1, testBean.getName());
        verify(mockPreparedStatement, times(1)).setString(2, testBean.getAddress());
        verify(mockPreparedStatement, times(1)).setString(3, testBean.getDescription());
        verify(mockPreparedStatement, times(1)).setInt(4, 25);
        verify(mockPreparedStatement, times(1)).execute();
    }
}
