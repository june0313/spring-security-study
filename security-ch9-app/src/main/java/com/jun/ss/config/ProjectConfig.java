package com.jun.ss.config;

import com.jun.ss.filters.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {

    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    public ProjectConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter) {
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .addFilterBefore(
//                        new RequestValidationFilter(),
//                        BasicAuthenticationFilter.class)
//                .addFilterAfter(
//                        new AuthenticationLoggingFilter(),
//                        BasicAuthenticationFilter.class)
//                .authorizeHttpRequests(auth ->
//                        auth.anyRequest().permitAll()
//                )
//                .build();

        return http
                .addFilterAt(
                        staticKeyAuthenticationFilter,
                        BasicAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }
}
