package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
    @RequestMapping("/policy")
    public String viewTermAndPolicy() {
        return "policy";
    }

    @RequestMapping("/info")
    public String getInfo() {
        return "info";
    }
}
