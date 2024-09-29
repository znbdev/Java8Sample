package com.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/app/first")
public class FirstController {
    private final MessageSource messageSource;

    @GetMapping("/get")
    public String getFirstApi() {
        log.info("This is the first Controller");
        log.info(messageSource.getMessage("app.name", null, Locale.getDefault()));
        log.info(messageSource.getMessage("app.name", null, Locale.CHINA));
        log.info(messageSource.getMessage("app.name", null, Locale.JAPAN));
        log.info(messageSource.getMessage("app.name", null, Locale.US));
        return "This is the first Controller";
    }
}
