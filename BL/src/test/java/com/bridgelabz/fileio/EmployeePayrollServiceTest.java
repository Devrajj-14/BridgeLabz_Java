package com.bridgelabz.fileio;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    private Path tempDir;
    private Path payrollFile;

    @BeforeEach
    void setup() throws IOException {
        tempDir = Files.createTempDirectory("bl-payroll-");
        payrollFile = tempDir.resolve("employee-payroll.txt");
    }

    @AfterEach
    void cleanup() throws IOException {
        if (Files.exists(tempDir)) {
            Files.walk(tempDir)
                    .sorted((a, b) -> b.compareTo(a))
                    .forEach(p -> {
                        try { Files.deleteIfExists(p); } catch (IOException ignored) {}
                    });
        }
    }

    @Test
    void givenEmployees_whenWrittenToFile_shouldMatchEntryCount() throws IOException {
        EmployeePayrollService service = new EmployeePayrollService(payrollFile);

        // UC4: populate data
        service.getEmployeeList(); // just to show list exists

        // add sample employees (directly)
        // simplest: create a new service list by reading console is not needed in unit test,
        // so we add using reflection-free approach: create file lines via service internals not exposed.
        // We'll do it by reading from file after writing our own list:
        // better: create a helper instance by writing through a temp object list:
        // For clean approach, create employees by reading lines:
        // We'll just use readFromFile/writeToFile using a trick: readEmployeePayrollDataFromFile clears list,
        // so we set list by reading a prepared file:
        Files.write(payrollFile, List.of(
                new EmployeePayrollData(1, "Bill", 10000).toCsvLine(),
                new EmployeePayrollData(2, "Mark", 20000).toCsvLine(),
                new EmployeePayrollData(3, "Charlie", 30000).toCsvLine()
        ), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // UC6: read into program
        List<EmployeePayrollData> loaded = service.readEmployeePayrollDataFromFile();
        assertEquals(3, loaded.size());

        // UC4: write back to file (same 3)
        service.writeEmployeePayrollDataToFile();

        // UC5: count entries
        long entries = service.countEntriesInFile();
        assertEquals(3, entries);
    }
}