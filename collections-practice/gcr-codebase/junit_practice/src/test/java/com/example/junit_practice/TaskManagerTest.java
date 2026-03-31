package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskManagerTest {

    private TaskManager manager;

    @BeforeEach
    public void setUp() {
        manager = new TaskManager();
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if test takes more than 2 seconds
    public void testLongRunningTask() {
        // This will fail because the task sleeps 3 seconds
        manager.longRunningTask();
    }
}
