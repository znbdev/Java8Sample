package com.example.entity;

public class Customer {
    private int id;
    private String name;

    // Constructors, getters, setters omitted for brevity

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
