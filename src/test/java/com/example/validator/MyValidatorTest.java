package com.example.validator;

import com.example.bean.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

class MyValidatorTest {
    @Test
    void testNotNullValidator() {
        NotNullValidator validator = new NotNullValidator();
        Assertions.assertTrue(validator.validate("test"));
        Assertions.assertNull(validator.getMessage());

        Assertions.assertFalse(validator.validate(null));
        Assertions.assertEquals("Value must not be null", validator.getMessage());
    }

    @Test
    void testLengthValidator() {
        LengthValidator validator = new LengthValidator(3, 5);
        Assertions.assertTrue(validator.validate("test"));
        Assertions.assertNull(validator.getMessage());

        Assertions.assertFalse(validator.validate("te"));
        Assertions.assertEquals("Length must be between 3 and 5", validator.getMessage());

        Assertions.assertFalse(validator.validate("testing"));
        Assertions.assertEquals("Length must be between 3 and 5", validator.getMessage());
    }

    @Test
    void testCustomTypeValidator() {
        CustomTypeValidator<Integer> validator = new CustomTypeValidator<>(Integer.class);
        Assertions.assertTrue(validator.validate(123));
        Assertions.assertNull(validator.getMessage());

        Assertions.assertFalse(validator.validate("test"));
        Assertions.assertEquals("Type must be Integer", validator.getMessage());
    }

    @Test
    void testFieldValidator() {
        User user = new User("John", 25);

        FieldValidator nameValidator = new FieldValidator(user.getName())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new LengthValidator(3, 50), String.class);

        FieldValidator ageValidator = new FieldValidator(user.getAge())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new CustomTypeValidator<>(Integer.class), Object.class);

        List<String> nameErrors = nameValidator.validate();
        List<String> ageErrors = ageValidator.validate();

        Assertions.assertTrue(nameErrors.isEmpty());
        Assertions.assertTrue(ageErrors.isEmpty());
    }

    @Test
    void testFieldValidatorWithErrors() {
        User user = new User("Jo", null);

        FieldValidator nameValidator = new FieldValidator(user.getName())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new LengthValidator(3, 50), String.class);

        FieldValidator ageValidator = new FieldValidator(user.getAge())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new CustomTypeValidator<>(Integer.class), Object.class);

        List<String> nameErrors = nameValidator.validate();
        List<String> ageErrors = ageValidator.validate();

        Assertions.assertEquals(1, nameErrors.size());
        Assertions.assertEquals("Length must be between 3 and 50", nameErrors.get(0));

        Assertions.assertEquals(1, ageErrors.size());
        Assertions.assertEquals("Value must not be null", ageErrors.get(0));
    }
}

