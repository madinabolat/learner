package com.example.learner.controller;


import com.example.learner.dto.UserLoginDto;
import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.service.UserService;
import com.example.learner.util.JwtUtil;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;
    private JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil){
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        try {
            userService.registerUser(userRegistrationDto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered.");
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginDto userLoginDto){

        try {
            if (userService.login(userLoginDto)){
                String token = jwtUtil.generateToken(userLoginDto.getUsername());
//                return ResponseEntity.status(HttpStatus.ACCEPTED).body("User logged in.");
                //add a map that will have both "User logged in" and token
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password.");
            }
        } catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such user.");
        }
    }


}
