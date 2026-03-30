package com.example.learner.service;

import com.example.learner.config.SecurityConfig;
import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegistrationDto userData) {
        User newUser = new User(userData.getUsername(), passwordEncoder.encode(userData.getPassword()));
        //save to DB
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
