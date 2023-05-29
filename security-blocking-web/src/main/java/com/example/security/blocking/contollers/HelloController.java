package com.example.security.blocking.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RestController
public class HelloController {

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        log.info("Hello test");
        return "Hello, " + authentication.getName() + "!";
    }

    @GetMapping("/hello2")
    public String hello() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return "Hello, " + authentication.getName() + "!";
    }

    @GetMapping("/bye")
    @Async
    public void goodbye() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        log.info("bye : {}", authentication.getName());
    }

    @GetMapping("/ciao")
    public String ciao() throws ExecutionException, InterruptedException {
        log.info("Ciao test");

        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            log.info("Ciao test");
            return context.getAuthentication().getName();
        };

        return "Ciao, " + POOL.submit(task).get() + "!";
    }

    @GetMapping("/thread")
    public String thread() {
        SecurityContext context = SecurityContextHolder.getContext();
        log.info("{}", context.getAuthentication().getName());

        new Thread(() -> {
            SecurityContext context1 = SecurityContextHolder.getContext();
            log.info("{}", context1.getAuthentication().getName());
        }).start();

        return "success";
    }
}
