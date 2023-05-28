package com.example.security.reactive.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class WebAuthorizationConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.httpBasic(Customizer.withDefaults())
                .authorizeExchange(authorize -> authorize.anyExchange().authenticated())
                .build();
    }
}
