package com.example.learner.service;

import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.model.User;

public interface UserService {
    void registerUser(UserRegistrationDto userData);
    User findByUsername(String username);
}
