package com.example.learner.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserRegistrationDto {
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    @Length(min = 3, max = 15)
    private String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
