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

public class H2DatabaseViewer {

    public static void main(String[] args) throws SQLException, IOException {
        DataSource dataSource = DataSourceConfig.getDataSource();

        selectTestBean(dataSource);
    }

    public static List<TestBeanEntity> selectTestBean(DataSource dataSource) {
        List<TestBeanEntity> testBeanEntities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM test_bean");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                int age = resultSet.getInt("age");
                System.out.printf("ID: %d, Name: %s, Address: %s, Description: %s, Age: %d%n", id, name, address, description, age);

                TestBeanEntity testBeanEntity = new TestBeanEntity(name, address, description, age);
                testBeanEntities.add(testBeanEntity);
            }
            return testBeanEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
