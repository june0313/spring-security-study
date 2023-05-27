package com.example.security.blocking.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(
    ) {
        return "Hello Blocking Web!";
    }
}
