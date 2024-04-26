package com.example.demo.Utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Regex {
    private Pattern pattern; 
    private static final String USERNAME_PATTERN = "^[a-z0-9._-]{3,15}$"; 
    
    public Regex() { 
        pattern = Pattern.compile(USERNAME_PATTERN); 
    } 
    
    public boolean validateUsername(final String username) { 
        return pattern.matcher(username).matches(); 
    } 
}
