package com.devmountain.tripPlanning.controllers;

import com.devmountain.tripPlanning.entities.User;
import com.devmountain.tripPlanning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trips/v1/user")
public class UserController {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public List<String> registerUser(@RequestBody User user) {
        String passHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passHash);
        return userService.register(user);
    }

    @PostMapping("/login")
    public List<String> logUserIn(@RequestBody User user) {
        return userService.login(user);
    }
}
