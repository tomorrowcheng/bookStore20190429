package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.Test;
import com.ncu.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    @Qualifier("testService")
    protected TestService testService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Test getTestById(@RequestParam("id") String id) {
        return testService.getById(Integer.parseInt(id));
    }
}
