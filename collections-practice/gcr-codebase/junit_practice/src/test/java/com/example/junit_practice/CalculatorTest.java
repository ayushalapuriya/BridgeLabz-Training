package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(10, calc.add(7, 3));
        assertEquals(-2, calc.add(-1, -1));
    }

    @Test
    public void testSubtract() {
        assertEquals(4, calc.subtract(7, 3));
        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(21, calc.multiply(7, 3));
        assertEquals(0, calc.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(5, calc.divide(10, 2));
        assertEquals(-3, calc.divide(9, -3));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
