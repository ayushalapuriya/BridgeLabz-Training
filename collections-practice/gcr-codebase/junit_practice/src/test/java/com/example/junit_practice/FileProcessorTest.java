package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileProcessorTest {

    private FileProcessor processor;
    private final String testFile = "testfile.txt";

    @BeforeEach
    public void setUp() {
        processor = new FileProcessor();
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Delete the file after each test if it exists
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";
        
        // Write to file
        processor.writeToFile(testFile, content);
        
        // Check if file exists
        assertTrue(Files.exists(Paths.get(testFile)), "File should exist after writing");
        
        // Read from file
        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent, "Content read should match content written");
    }

    @Test
    public void testReadNonExistingFile() {
        // Attempt to read a file that doesn't exist
        Exception exception = assertThrows(IOException.class, () -> {
            processor.readFromFile("nonexistent.txt");
        });

        // Optional: check if exception message contains the filename
        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }
}
