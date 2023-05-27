package com.example.security.blocking.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String username;
    private String password;
    private String authority;
}
