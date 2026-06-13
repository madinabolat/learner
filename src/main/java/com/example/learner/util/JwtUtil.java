package com.example.learner.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String secret;

    SecretKey getSignInKey(){
        byte[] secretBytes = secret.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(secretBytes);
        return key;
    }

    public String generateToken(String username){
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(Date.from(now.toInstant().plus(1, ChronoUnit.HOURS)))
                .signWith(getSignInKey())
                .compact();
    }

    Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token){
        try {
            getClaims(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public String extractUsername(String token){
        return getClaims(token)
                .getSubject();
    }
}
