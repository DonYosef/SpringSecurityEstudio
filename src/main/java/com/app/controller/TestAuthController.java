package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @PreAuthorize("permitAll()")
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @PreAuthorize("hasAuthority('CREATE')")
    @GetMapping("/hello-secured")
    public String helloSecured(){
        return "Hello Secured!";
    }
}
