package com.example.validator;

import java.util.ArrayList;
import java.util.List;

public class FieldValidator {
    private Object value;
    private List<MyValidator<Object>> validators = new ArrayList<>();

    public FieldValidator(Object value) {
        this.value = value;
    }

    public <T> FieldValidator addValidator(MyValidator<T> validator, Class<T> type) {
        validators.add(new MyValidator<Object>() {
            @Override
            public boolean validate(Object value) {
                if (type.isInstance(value)) {
                    return validator.validate(type.cast(value));
                } else {
                    return false;
                }
            }

            @Override
            public String getMessage() {
                return validator.getMessage();
            }
        });
        return this;
    }

    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        for (MyValidator<Object> validator : validators) {
            if (!validator.validate(value)) {
                errors.add(validator.getMessage());
            }
        }
        return errors;
    }
}

