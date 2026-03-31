package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Calculator1Test {

    private Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testDivideByZero() {
        // assertThrows expects the exception class and a lambda that triggers it
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });

        // Verify the exception message
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testDivideNormal() {
        assertEquals(5, calc.divide(10, 2));
        assertEquals(-3, calc.divide(9, -3));
    }
}
