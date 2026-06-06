package com.example.learner.util;


import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String secret;

    String generateToken(String username){
        return Jwts.builder()
                .addClaims()
                .setPayload()
                .setIssuedAt()
                .setExpiration();
    }

    boolean validateToken(String token){
        return false;
    }
}
