package com.example.learner.service;

import com.example.learner.dto.UserLoginDto;
import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.model.User;
import com.example.learner.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public void registerUser(UserRegistrationDto userData) {
        if (userRepository.findByUsername(userData.getUsername()) != null){
            throw new IllegalArgumentException();
        }
        User newUser = new User(userData.getUsername(), passwordEncoder.encode(userData.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) {
        User user = findByUsername(userLoginDto.getUsername());
        if (user == null){
            throw new UsernameNotFoundException(userLoginDto.getUsername());
        } else {
            return passwordEncoder.matches(userLoginDto.getPassword(), user.getPasswordHash());
        }
    }
}
