package com.example.springboothelloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController2 {
    @RequestMapping("/index2")
    public String index2() {
        int i = 1 / 0;
        return "index2";
    }
}
