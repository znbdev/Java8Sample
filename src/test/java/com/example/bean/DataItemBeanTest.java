package com.example.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DataItemBeanTest {

    /**
     * Parameterized test data
     * Each parameter set is a triplet of text, number, and expected result
     */
    private final String text;
    private final Integer number;
    private final boolean expectedResult;

    public DataItemBeanTest(String text, Integer number, boolean expectedResult) {
        this.text = text;
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Hello", 12345, true},
                {null, 12345, false},
                {"A", 12345, false},
                {"ThisIsTooLong", 12345, false},
                {"Hello", null, false},
                {"Hello", 1234, false},
                {"Hello", 123456, false}
        });
    }

    /**
     * Independent test methods for each parameter set
     */
    @Test
    public void testIsValid() {
        DataItemBean dataItemBean = new DataItemBean(text, number);
        assertEquals(expectedResult, dataItemBean.isValid());
    }

    @Test
    public void testValidBean() {
        DataItemBean validBean = new DataItemBean("Hello", 12345);
        assertTrue(validBean.isValid());
    }

    @Test
    public void testInvalidTextNull() {
        DataItemBean invalidBean = new DataItemBean(null, 12345);
        assertFalse(invalidBean.isValid());
    }

    @Test
    public void testInvalidTextTooShort() {
        DataItemBean invalidBean = new DataItemBean("A", 12345);
        assertFalse(invalidBean.isValid());
    }

    @Test
    public void testInvalidTextTooLong() {
        DataItemBean invalidBean = new DataItemBean("ThisIsTooLong", 12345);
        assertFalse(invalidBean.isValid());
    }

    @Test
    public void testInvalidNumberNull() {
        DataItemBean invalidBean = new DataItemBean("Hello", null);
        assertFalse(invalidBean.isValid());
    }

    @Test
    public void testInvalidNumberTooShort() {
        DataItemBean invalidBean = new DataItemBean("Hello", 1234);
        assertFalse(invalidBean.isValid());
    }

    @Test
    public void testInvalidNumberTooLong() {
        DataItemBean invalidBean = new DataItemBean("Hello", 123456);
        assertFalse(invalidBean.isValid());
    }
}