package com.example.db.h2;

import com.example.config.DataSourceConfig;
import com.example.entity.TestBeanEntity;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class H2DatabaseViewerTest {

    @Mock
    private DataSource mockDataSource;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @Before
    public void setup() throws SQLException {
        MockitoAnnotations.initMocks(this);

        // Mock the behavior of DataSource methods
        when(mockDataSource.getConnection()).thenReturn(mockConnection);

        // Mock the behavior of Connection methods
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Mock the behavior of PreparedStatement methods
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock the behavior of ResultSet methods
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // Simulate one row in result set
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("John Doe");
        when(mockResultSet.getString("address")).thenReturn("123 Main St");
        when(mockResultSet.getString("description")).thenReturn("A description");
        when(mockResultSet.getInt("age")).thenReturn(25);
    }

    @Test
    public void testSelectTestBean() throws SQLException {
        List<TestBeanEntity> expectedEntities = new ArrayList<>();
        expectedEntities.add(new TestBeanEntity("John Doe", "123 Main St", "A description", 25));

        // Call the method under test
        List<TestBeanEntity> actualEntities = H2DatabaseViewer.selectTestBean(mockDataSource);

        // Verify that PreparedStatement and ResultSet methods were called with the correct parameters
        verify(mockConnection, times(1)).prepareStatement("SELECT * FROM test_bean");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next(); // Verify next() is called exactly twice
        verify(mockResultSet, times(1)).getInt("id");
        verify(mockResultSet, times(1)).getString("name");
        verify(mockResultSet, times(1)).getString("address");
        verify(mockResultSet, times(1)).getString("description");
        verify(mockResultSet, times(1)).getInt("age");

        // Verify the returned list contains expected entities
        assertEquals(expectedEntities.size(), actualEntities.size());
        assertEquals(expectedEntities.get(0).getName(), actualEntities.get(0).getName());
        assertEquals(expectedEntities.get(0).getAddress(), actualEntities.get(0).getAddress());
        assertEquals(expectedEntities.get(0).getDescription(), actualEntities.get(0).getDescription());
        assertEquals(expectedEntities.get(0).getAge(), actualEntities.get(0).getAge());
    }
}
