package com.devmountain.tripPlanning.services;

import com.devmountain.tripPlanning.entities.User;

import java.util.List;

public interface UserService {

    public List<String> register(User user);

    public List<String> login(User user);
}
