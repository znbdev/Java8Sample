package com.example.validator;

import com.example.bean.ErrorBean;

import java.lang.reflect.Field;

public class ValidTrueValidator {
    public static <T> ErrorBean validate(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidTrue.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value == null) {
                        ValidTrue annotation = field.getAnnotation(ValidTrue.class);
                        String projectName = annotation.fieldName();
                        String errorCode = annotation.errorCode();
                        String errorMessage = annotation.errorMessage();
                        return new ErrorBean(projectName, errorCode, errorMessage);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null; // 返回 null 表示验证通过
    }
}
