package com.sharath.car_database.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    static final long EXPIRATION_TIME = 86400000; // 1 day
    static final String PREFIX = "Bearer ";

    // demonstration purpose only, in production we should get this from application configuration
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // generating signed Jwt
    public String getToken(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
        return token;

    }

    // get a token from req authorization header, verify username and passwd

    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null){
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if(user != null){
                return user;
            }
        }
        return null;

    }
}
