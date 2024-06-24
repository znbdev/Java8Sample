package com.example.generator.bean;

import com.example.annotation.AnnotationValidator;
import com.example.entity.User;

import java.util.List;

public class JavaTemplateBean {

    public static void userValidator() {
        User user = new User("Java900Template", 25);
        AnnotationValidator validator = new AnnotationValidator();

        List<String> errors = validator.validate(user);

        if (errors.isEmpty()) {
            System.out.println("java900Template");
        } else {
            System.out.println("java900template");
            errors.forEach(System.out::println);
        }

    }
}
