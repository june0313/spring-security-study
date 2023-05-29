package com.example.security.blocking.configs;

import com.example.security.blocking.services.CustomEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthorizationConfig {
    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(c -> {
                    c.realmName("OTHER");
                    c.authenticationEntryPoint(new CustomEntryPoint());
                })
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .build();
    }
}
