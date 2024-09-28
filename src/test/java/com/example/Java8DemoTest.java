package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Java8DemoTest {

    @Test
    void forEachDemo() {
        Java8Demo.forEachDemo();
    }

    @Test
    void userValidatorTest() {
        Java8Demo.userValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithMultipleValues(int value) {
        assertEquals(value, value);
    }
}