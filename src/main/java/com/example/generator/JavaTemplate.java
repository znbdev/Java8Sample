package com.example.generator;

import com.example.annotation.AnnotationValidator;
import com.example.entity.User;

import java.util.List;

public class JavaTemplate {

    public static void userValidator() {
        User user = new User("JavaTemplate", 25);
        AnnotationValidator validator = new AnnotationValidator();

        List<String> errors = validator.validate(user);

        if (errors.isEmpty()) {
            System.out.println("User is valid");
        } else {
            System.out.println("Validation errors:");
            errors.forEach(System.out::println);
        }

    }
}
