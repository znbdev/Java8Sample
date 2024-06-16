package com.example.validator;

public interface MyValidator<T> {
    boolean validate(T t);
    String getMessage();
}






