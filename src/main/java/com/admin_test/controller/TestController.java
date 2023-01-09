package com.admin_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World!");
        return "home";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String list() {
        return "hello";
    }
    @GetMapping(value = "/list")
    public String indexPage() {
        return "list";
    }
}

