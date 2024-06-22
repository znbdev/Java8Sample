package com.example.dao;

import com.example.bean.TestBean;
import com.example.entity.TestBeanEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBeanDao {

    private final DataSource dataSource;

    public TestBeanDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTable() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE test_bean (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), address VARCHAR(255), description VARCHAR(255), age INT)")) {
            statement.execute();
        }
    }

    public void insertTestBean(TestBean bean) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO test_bean (name, address, description, age) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, bean.getName());
            statement.setString(2, bean.getAddress());
            statement.setString(3, bean.getDescription());
            statement.setInt(4, Integer.parseInt(bean.getAge().toString()));
            statement.execute();
        }
    }

    public TestBeanEntity getTestBeanById(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM test_bean WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new TestBeanEntity(
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getString("description"),
                            resultSet.getInt("age")
                    );
                }
                return null;
            }
        }
    }
}

