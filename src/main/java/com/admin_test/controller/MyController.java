package com.admin_test.controller;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/checkConnection")
    public ModelAndView greet() {
        try {
            if (dataSource.getConnection() != null) {
                return new ModelAndView("index", "msg", "Database Connection Successfully Established.");
            } else {
                return new ModelAndView("index", "msg", "Failed to connect database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelAndView("index", "msg", "Failed to connect database.");
        }
    }
}