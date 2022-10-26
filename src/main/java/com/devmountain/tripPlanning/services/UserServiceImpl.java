package com.devmountain.tripPlanning.services;

import com.devmountain.tripPlanning.entities.User;
import com.devmountain.tripPlanning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> register(User user) {
        List<String> response = new ArrayList<>();
        userRepository.saveAndFlush(user);
        response.add("http://localhost:8080/loginpage.html");
        return response;
    }

    @Override
    public List<String> login(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        List<String> response = new ArrayList<>();
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(user.getPassword(), userOptional.get().getPassword())) {
                response.add("http://localhost:8080/homepage.html");
                response.add(String.valueOf(userOptional.get().getId()));
                response.add(String.valueOf(userOptional.get().getUsername()));
            } else {
                response.add("password incorrect");
            }
        } else {
            response.add("user not found");
        }
        return response;
    }
}