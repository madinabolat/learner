package com.example.learner.controller;


import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserRegistrationDto userRegistrationDto){
        try {
            userService.registerUser(userRegistrationDto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("User already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered.");
    }


}
