package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestBeanEntity {
    private String name;

    private String address;

    private String description;

    private Integer age;

    // Constructor, getters, and setters
    public TestBeanEntity(String name, String address, String description, Integer age) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.age = age;
    }
}
