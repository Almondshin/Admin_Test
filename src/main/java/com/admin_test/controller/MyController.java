package com.admin_test.controller;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

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