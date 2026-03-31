package com.example.junit_practice;

import java.util.regex.Pattern;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.length() < 3) 
            throw new IllegalArgumentException("Invalid username");
        if (email == null || !Pattern.matches("^.+@.+\\..+$", email))
            throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("Invalid password");
        
        // Registration successful (dummy logic)
    }
}
