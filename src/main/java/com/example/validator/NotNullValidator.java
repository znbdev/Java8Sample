package com.example.validator;

public class NotNullValidator implements MyValidator<Object> {
    private String message;

    @Override
    public boolean validate(Object value) {
        if (value == null) {
            message = "Value must not be null";
            return false;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
