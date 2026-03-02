package com.bridgelabz.fileio;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    private Path tempDir;
    private FileOperations ops;

    @BeforeEach
    void setup() throws IOException {
        ops = new FileOperations();
        tempDir = Files.createTempDirectory("bl-fileio-");
    }

    @AfterEach
    void cleanup() throws IOException {
        // delete temp directory recursively
        if (Files.exists(tempDir)) {
            Files.walk(tempDir)
                    .sorted((a, b) -> b.compareTo(a)) // delete children first
                    .forEach(p -> {
                        try { Files.deleteIfExists(p); } catch (IOException ignored) {}
                    });
        }
    }

    @Test
    void givenPath_shouldCheckExists_createDir_createFile_list_and_filter() throws IOException {
        Path dir = tempDir.resolve("payroll");
        ops.createDirectory(dir);
        assertTrue(ops.exists(dir));

        Path file1 = dir.resolve("employees.txt");
        Path file2 = dir.resolve("notes.md");

        ops.createEmptyFile(file1);
        ops.createEmptyFile(file2);

        assertTrue(ops.exists(file1));
        assertTrue(ops.exists(file2));

        List<Path> all = ops.listAll(dir);
        assertEquals(2, all.size());

        List<Path> txtOnly = ops.listByExtension(dir, ".txt");
        assertEquals(1, txtOnly.size());
        assertTrue(txtOnly.get(0).getFileName().toString().endsWith(".txt"));

        // delete file and verify not exist
        assertTrue(ops.deleteIfExists(file1));
        assertFalse(ops.exists(file1));
    }
}