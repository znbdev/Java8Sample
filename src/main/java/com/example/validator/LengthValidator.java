package com.example.validator;

public class LengthValidator implements MyValidator<String> {
    private int minLength;
    private int maxLength;
    private String message;

    public LengthValidator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean validate(String value) {
        if (value.length() < minLength || value.length() > maxLength) {
            message = "Length must be between " + minLength + " and " + maxLength;
            return false;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return message;
    }
}