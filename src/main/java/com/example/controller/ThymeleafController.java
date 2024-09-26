package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ThymeleafController {

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/dynamicPage")
    public String dynamicPage(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "dynamicPage";
    }

    @GetMapping("/testPage")
    public String testPage(Model model) {
        return "testPage";
    }

    @GetMapping("/dynamicDialogPage")
    public String dynamicDialogPage(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "dynamicDialogPage";
    }

    @GetMapping("/testDialogPage")
    public String testDialogPage(Model model) {
        log.info("testDialogPage");
        return "testDialogPage";
    }
}
