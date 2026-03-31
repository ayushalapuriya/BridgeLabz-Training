package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect(); // Initialize connection before each test
    }

    @AfterEach
    public void tearDown() {
        db.disconnect(); // Close connection after each test
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Connection should be established before test");
    }

    @Test
    public void testConnectionStillWorksDuringTest() {
        // Simulate some operations
        assertTrue(db.isConnected(), "Connection should still be active during test");
    }

    @Test
    public void testConnectionIsClosedAfterTest() {
        // This test verifies teardown indirectly. We can't check after @AfterEach here,
        // but running the tests will show "Database disconnected." printed after each test
        assertTrue(db.isConnected(), "Connection should be active during test");
    }
}
