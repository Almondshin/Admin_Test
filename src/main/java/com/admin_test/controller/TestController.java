package com.admin_test.controller;

import com.admin_test.dao.TestDao;
import com.admin_test.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestDao testDao;

    @RequestMapping("saveFundList")
    @ResponseBody
    public String saveFundList() {
        Test test = new Test();

        test.setFundname("spring");
        test.setContents("This will tell you how to connect with databases in a spring project");
        test.setReword("Reword set");
        testDao.add(test);
        return "title name which is saved is "+ test.getFundcode();
    }
}

