package com.example.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(
    ) {
        return "Hello!";
    }

    @GetMapping("/hello2")
    public Mono<String> hello2(
    ) {
        return Mono.just("Hello2!");
    }
}
