package com.example.bean;

import com.example.annotation.Length;
import com.example.annotation.NotEmpty;
import com.example.annotation.NotNull;
import com.example.annotation.Type;
import lombok.Data;

@Data
public class TestBean {
    @NotNull(message = "name must not be null")
    private String name;

    @NotEmpty(message = "address must not be empty")
    private String address;

    @Length(min = 3, max = 10, message = "description length must be between {min} and {max}")
    private String description;

    @Type(value = Integer.class, message = "age must be of type {value}")
    private Object age;

    // Constructor, getters, and setters
    public TestBean(String name, String address, String description, Object age) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.age = age;
    }
}
