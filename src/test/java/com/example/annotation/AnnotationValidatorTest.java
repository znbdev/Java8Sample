package com.example.annotation;

import com.example.bean.TestBean;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnnotationValidatorTest {

    private AnnotationValidator validator;

    @Before
    public void setUp() {
        validator = new AnnotationValidator();
    }

    @Test
    public void testNotNull() {
        TestBean bean = new TestBean(null, "123 Main St", "Desc", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("name must not be null"));
    }

    @Test
    public void testNotEmpty() {
        TestBean bean = new TestBean("John", "", "Desc", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("address must not be empty"));
    }

    @Test
    public void testLength() {
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
    public void testType() {
        TestBean bean = new TestBean("John", "123 Main St", "Desc", "25");
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());
        assertTrue(errors.contains("age must be of type Integer"));
    }

    @Test
    public void testValidBean() {
        TestBean bean = new TestBean("John", "123 Main St", "Description", 25);
        List<String> errors = validator.validate(bean);
        assertEquals(1, errors.size());}
}
