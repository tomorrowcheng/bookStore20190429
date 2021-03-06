package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.Test;
import com.ncu.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试
 */
@CrossOrigin
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
