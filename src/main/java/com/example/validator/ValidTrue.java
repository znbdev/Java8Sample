package com.example.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTrue {
    String fieldName() default "";

    String errorCode() default "E404";

    String errorMessage() default "{fieldName} 不能为空";
}

