package com.example.security.blocking.configs;

import com.example.security.blocking.services.PlainTextPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        var usersByUsernameQuery = "select username, password, enabled from members where username = ?";
        var authsByUserQuery = "select username, role from roles where username = ?";

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);

        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlainTextPasswordEncoder();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        var encoders = new HashMap<String, PasswordEncoder>();

        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());

        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }*/

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/
}
