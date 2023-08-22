package com.springsecurity.ssia_ch2_ex2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ch2-ex2")
@RequestMapping("/ch2-ex2")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from ch2-ex2!";
    }
}
