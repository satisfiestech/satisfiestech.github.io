package com.satisfiestech.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Configure AuthenticationManager with in-memory users (example)
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//            .inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//            .and()
//                .withUser("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .roles("ADMIN")
//            .and()
//            .and()
//            .build();
//    }
//
//    // Configure HTTP security (which endpoints require authentication, etc)
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()  // For APIs, might want to disable CSRF; else keep enabled
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/admin/**").hasRole("ADMIN")   // Only ADMIN role can access /admin/**
//                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER or ADMIN role can access /user/**
//                .anyRequest().permitAll()  // Other endpoints are public
//            )
//            .formLogin()  // Enable form login
//            .and()
//            .logout()
//                .permitAll();
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Allow all requests
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // Disable login popup

        return http.build();
    }

}

