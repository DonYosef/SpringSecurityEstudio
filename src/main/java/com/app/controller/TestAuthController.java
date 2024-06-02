package com.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {

    @PostMapping
    public String postHello(){
        return "Hello post";
    }
    @GetMapping
    public String getHello(){
        return "Hello get";
    }
    @PutMapping
    public String putHello(){
        return "Hello put";
    }
    @DeleteMapping()
    public String deleteHello(){
        return "Hello delete";
    }


}
