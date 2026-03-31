package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private ListManager manager;
    private List<Integer> numbers;

    @BeforeEach
    public void setUp() {
        manager = new ListManager();
        numbers = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        manager.addElement(numbers, 5);
        manager.addElement(numbers, 10);

        assertEquals(2, numbers.size());
        assertTrue(numbers.contains(5));
        assertTrue(numbers.contains(10));
    }

    @Test
    public void testRemoveElement() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        manager.removeElement(numbers, 2);
        assertEquals(2, numbers.size());
        assertFalse(numbers.contains(2));

        manager.removeElement(numbers, 100);
        assertEquals(2, numbers.size());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, manager.getSize(numbers));

        numbers.add(1);
        numbers.add(2);
        assertEquals(2, manager.getSize(numbers));

        manager.removeElement(numbers, 1);
        assertEquals(1, manager.getSize(numbers));
    }
}
