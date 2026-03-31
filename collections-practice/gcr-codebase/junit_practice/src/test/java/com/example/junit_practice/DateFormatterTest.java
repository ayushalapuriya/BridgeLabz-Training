package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    private DateFormatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    public void testValidDate() {
        assertEquals("31-12-2023", formatter.formatDate("2023-12-31"));
    }

    @Test
    public void testInvalidDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("31-12-2023");
        });
        assertEquals("Invalid date format", exception.getMessage());
    }
}
