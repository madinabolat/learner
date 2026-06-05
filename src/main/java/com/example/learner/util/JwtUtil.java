package com.example.learner.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String secret;

    String generateToken(String username){
        return "";
        //@Value("${SECRET_KEY}")
    }

    boolean validateToken(String token){
        return false;
    }
}
