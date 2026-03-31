package com.example.junit_practice;

public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false; // At least 1 uppercase
        if (!password.matches(".*\\d.*")) return false;   // At least 1 digit
        return true;
    }
}
