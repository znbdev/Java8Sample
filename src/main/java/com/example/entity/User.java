package com.example.entity;

import com.example.annotation.Length;
import com.example.annotation.NotNull;
import com.example.annotation.Type;
import lombok.Data;

@Data
public class User {
    @NotNull(message = "{fieldName} must not be null")
    @Length(min = 3, max = 50, message = "{fieldName} length must be between 3 and 50")
    private String name;

    @NotNull(message = "{fieldName} must not be null")
    @Type(value = Integer.class, message = "{fieldName} must be an integer")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
