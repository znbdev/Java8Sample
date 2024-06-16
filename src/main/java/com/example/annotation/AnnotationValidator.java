package com.example.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationValidator {
    private static final String FIELD_NAME_PLACEHOLDER = "{fieldName}";

    public List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class)) {
                    validateNotNull(value, field.getAnnotation(NotNull.class), errors, field.getName());
                }

                if (field.isAnnotationPresent(Length.class) && value instanceof String) {
                    validateStringLength((String) value, field.getAnnotation(Length.class), errors, field.getName());
                }

                if (field.isAnnotationPresent(Type.class)) {
                    validateType(value, field.getAnnotation(Type.class), errors, field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // TODO: Change to error log
            } finally {
                field.setAccessible(false);
            }
        }

        return errors;
    }

    private void validateNotNull(Object value, NotNull annotation, List<String> errors, String fieldName) {
        if (value == null) {
            errors.add(annotation.message().replace(FIELD_NAME_PLACEHOLDER, fieldName));
        }
    }

    private void validateStringLength(String strValue, Length annotation, List<String> errors, String fieldName) {
        if (strValue.length() < annotation.min() || strValue.length() > annotation.max()) {
            errors.add(annotation.message()
                    .replace("{min}", String.valueOf(annotation.min()))
                    .replace("{max}", String.valueOf(annotation.max()))
                    .replace(FIELD_NAME_PLACEHOLDER, fieldName));
        }
    }

    private void validateType(Object value, Type annotation, List<String> errors, String fieldName) {
        if (!annotation.value().isInstance(value)) {
            errors.add(annotation.message().replace("{value}", annotation.value().getSimpleName())
                    .replace(FIELD_NAME_PLACEHOLDER, fieldName));
        }
    }
}


