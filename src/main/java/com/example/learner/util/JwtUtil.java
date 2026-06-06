package com.example.learner.util;


import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String secret;

    String generateToken(String username){
        Date now = new Date();
        //generate key: 
//        Key key = secret.getBytes();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(Date.from(now.toInstant().plus(1, ChronoUnit.HOURS)))
//                .signWith(secret)
                .compact();
    }

    boolean validateToken(String token){
        return false;
    }
}
