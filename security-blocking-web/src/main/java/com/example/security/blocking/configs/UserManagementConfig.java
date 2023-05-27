package com.example.security.blocking.configs;

import com.example.security.blocking.model.SimpleUser;
import com.example.security.blocking.services.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserManagementConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var simpleUser = new SimpleUser("john", "12345", "read");
        List<UserDetails> simpleUsers = List.of(simpleUser);

        return new InMemoryUserDetailsService(simpleUsers);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
