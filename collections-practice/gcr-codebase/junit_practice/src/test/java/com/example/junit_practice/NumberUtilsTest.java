package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    private NumberUtils utils;

    @BeforeEach
    public void setUp() {
        utils = new NumberUtils();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    public void testIsEven(int number) {
        if (number % 2 == 0) {
            assertTrue(utils.isEven(number), number + " should be even");
        } else {
            assertFalse(utils.isEven(number), number + " should be odd");
        }
    }
}
