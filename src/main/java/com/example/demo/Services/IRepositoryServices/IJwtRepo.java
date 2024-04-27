package com.example.demo.Services.IRepositoryServices;

import java.util.Map;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtRepo
{
    String generateToken(UserDetails userDetails);


    String extractUserName(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshToken(Map<String, Objects> extraClaims, UserDetails userDetails);
}
