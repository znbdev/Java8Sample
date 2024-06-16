package com.example.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationValidator {
    public List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();

        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class)) {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    if (value == null) {
                        errors.add(notNull.message());
                    }
                }

                if (field.isAnnotationPresent(Length.class) && value instanceof String) {
                    Length length = field.getAnnotation(Length.class);
                    String strValue = (String) value;
                    if (strValue.length() < length.min() || strValue.length() > length.max()) {
                        errors.add(length.message().replace("{min}", String.valueOf(length.min()))
                                .replace("{max}", String.valueOf(length.max())));
                    }
                }

                if (field.isAnnotationPresent(Type.class)) {
                    Type type = field.getAnnotation(Type.class);
                    if (!type.value().isInstance(value)) {
                        errors.add(type.message().replace("{value}", type.value().getSimpleName()));
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return errors;
    }
}
