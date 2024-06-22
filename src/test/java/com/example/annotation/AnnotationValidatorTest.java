package com.example.annotation;

import com.example.bean.TestBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AnnotationValidatorTest {

    private AnnotationValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new AnnotationValidator();
    }

    @Test
    void testNotNull() {
        TestBean bean = new TestBean(null, "123 Main St", "Desc", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("name must not be null"));
    }

    @Test
    void testNotEmpty() {
        TestBean bean = new TestBean("John", "", "Desc", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("address must not be empty"));
    }

    @Test
    void testLength() {
        TestBean bean = new TestBean("John", "123 Main St", "De", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("description length must be between 3 and 10"));

        bean.setDescription("Description is too long");
        errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("description length must be between 3 and 10"));
    }

    @Test
    void testType() {
        TestBean bean = new TestBean("John", "123 Main St", "Desc", "25");
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("age must be of type Integer"));
    }

    @Test
    void testValidBean() {
        TestBean bean = new TestBean("John", "123 Main St", "Description", 25);
        List<String> errors = validator.validate(bean);
        assertFalse(errors.isEmpty());
    }
}
