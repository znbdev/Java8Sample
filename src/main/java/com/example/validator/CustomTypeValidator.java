package com.example.validator;

public class CustomTypeValidator<T> implements MyValidator<Object> {
    private Class<T> type;
    private String message;

    public CustomTypeValidator(Class<T> type) {
        this.type = type;
    }

    @Override
    public boolean validate(Object value) {
        if (!type.isInstance(value)) {
            message = "Type must be " + type.getSimpleName();
            return false;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
