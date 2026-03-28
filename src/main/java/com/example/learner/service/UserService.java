package com.example.learner.service;

import com.example.learner.model.User;

public interface UserService {
    void registerUser(UserRegistrationDto userData);
    //TO DO create UserRegistrationDto
    User findByUsername(String username);
}
