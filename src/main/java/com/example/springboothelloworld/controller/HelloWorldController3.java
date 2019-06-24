package com.example.springboothelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController3 {
    @RequestMapping("index3")
    public String index3(Map<String, Object> result) {
        System.out.println("HelloWorldController3-------index3");
        result.put("name", "querenjie");
        result.put("gender", 1);
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        result.put("userlist", list);
        return "freemarker1";
    }
}
