package com.satisfiestech.ecommerce.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.satisfiestech.ecommerce.model.User;
import com.satisfiestech.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public UserController(UserRepository repo) {
        this.repo = repo;
        this.encoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (repo.existsByEmail(user.getEmail())) {
            return "Email already exists";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered successfully";
    }
}
