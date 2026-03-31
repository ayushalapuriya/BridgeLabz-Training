package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPasswords() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("Abcdefg1H"));
    }

    @Test
    public void testInvalidPasswords() {
        assertFalse(validator.isValid("short1"));    // Too short
        assertFalse(validator.isValid("nouppercase1")); // No uppercase
        assertFalse(validator.isValid("NOLOWERCASE1")); // No lowercase not required
        assertFalse(validator.isValid("NoDigit"));   // No digit
    }
}
