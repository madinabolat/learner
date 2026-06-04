package com.example.learner.util;

import com.example.learner.dto.UserLoginDto;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    String generateToken(String username){
        return "";
        //@Value("${SECRET_KEY}")
    }

    boolean validateToken(String token){
        return false;
    }
}
