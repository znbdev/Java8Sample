package com.example.annotation;

import com.example.entity.User;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AnnotationValidatorTest {
    @Test
    void testValidUser() {
        User user = new User("John", 25);
        AnnotationValidator validator = new AnnotationValidator();
        List<String> errors = validator.validate(user);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    void testUserWithErrors() {
        User user = new User("Jo", null);
        AnnotationValidator validator = new AnnotationValidator();
        List<String> errors = validator.validate(user);

        Assertions.assertEquals(3, errors.size());
        Assertions.assertEquals("Name length must be between 3 and 50", errors.get(0));
        Assertions.assertEquals("Age must not be null", errors.get(1));
        Assertions.assertEquals("Age must be an integer", errors.get(2));
    }

    @Test
    void testInvalidAgeType() {
        @Getter
        class InvalidUser {
            @NotNull(message = "Name must not be null")
            @Length(min = 3, max = 50, message = "Name length must be between 3 and 50")
            private String name = "John";

            @NotNull(message = "Age must not be null")
            @Type(value = Integer.class, message = "Age must be an integer")
            private String age = "twenty-five";

        }

        InvalidUser user = new InvalidUser();
        AnnotationValidator validator = new AnnotationValidator();
        List<String> errors = validator.validate(user);

        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("Age must be an integer", errors.get(0));
    }
}