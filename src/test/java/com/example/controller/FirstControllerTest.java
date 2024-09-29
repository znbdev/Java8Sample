package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FirstController.class)
class FirstControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        // Mock the responses for different locales
        when(messageSource.getMessage("app.name", null, Locale.getDefault())).thenReturn("Default App Name");
        when(messageSource.getMessage("app.name", null, Locale.CHINA)).thenReturn("应用名称");
        when(messageSource.getMessage("app.name", null, Locale.JAPAN)).thenReturn("アプリ名");
        when(messageSource.getMessage("app.name", null, Locale.US)).thenReturn("App Name US");
    }

    @Test
    void testGetFirstApi() throws Exception {
        mockMvc.perform(get("/app/first/get"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is the first Controller"));
    }
}
