package com.example.springboothelloworld.controller;


import com.example.springboothelloworld.util.Log4jUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {
    private static final Logger logger = LogManager.getLogger(HelloWorldController.class);
    @RequestMapping("/index")
    public String index() {
        return "success";
    }

    @RequestMapping("/getMap")
    public Map<String, Object> getMap() {
        Log4jUtil.info(logger, "come into HelloWorldController.getMap()");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errorCode", "200");
        result.put("errorMsg", "成功。。");
        return result;
    }

}
