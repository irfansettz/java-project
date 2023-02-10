package com.example.d9httpspringboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/messages")
public class HelloWorld {
    @GetMapping
    public String getSayHello(){
        return "Hello World!";
    }

    @PostMapping
    public String postSayHello(){
        return "Hello World!";
    }

    @DeleteMapping
    public String deleteSayHello(){
        return "Hello World!";
    }
}
