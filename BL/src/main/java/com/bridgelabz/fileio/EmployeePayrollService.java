package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private final Path payrollFilePath;

    public EmployeePayrollService(Path payrollFilePath) {
        this.payrollFilePath = payrollFilePath;
    }

    // UC1: read from console
    public void readEmployeePayrollData(Scanner sc) {
        System.out.print("Enter Employee Id: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = Double.parseDouble(sc.nextLine().trim());

        employeeList.add(new EmployeePayrollData(id, name, salary));
    }

    // UC1: write to console
    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService == IOService.CONSOLE_IO) {
            employeeList.forEach(System.out::println);
        } else {
            throw new UnsupportedOperationException("Use writeEmployeePayrollDataToFile() for FILE_IO");
        }
    }

    public List<EmployeePayrollData> getEmployeeList() {
        return Collections.unmodifiableList(employeeList);
    }

    // UC4: write payroll to file
    public void writeEmployeePayrollDataToFile() throws IOException {
        ensureParentDirExists();
        List<String> lines = employeeList.stream()
                .map(EmployeePayrollData::toCsvLine)
                .collect(Collectors.toList());

        Files.write(payrollFilePath, lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
    }

    // UC6: read payroll from file back into program
    public List<EmployeePayrollData> readEmployeePayrollDataFromFile() throws IOException {
        if (!Files.exists(payrollFilePath)) return List.of();

        List<String> lines = Files.readAllLines(payrollFilePath);
        List<EmployeePayrollData> loaded = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;
            loaded.add(EmployeePayrollData.fromCsvLine(line));
        }
        employeeList.clear();
        employeeList.addAll(loaded);
        return Collections.unmodifiableList(employeeList);
    }

    // UC5: print file data
    public void printDataFromFile() throws IOException {
        if (!Files.exists(payrollFilePath)) {
            System.out.println("Payroll file not found: " + payrollFilePath);
            return;
        }
        Files.lines(payrollFilePath).forEach(System.out::println);
    }

    // UC4/UC5: count entries in payroll file
    public long countEntriesInFile() throws IOException {
        if (!Files.exists(payrollFilePath)) return 0;
        try (var lines = Files.lines(payrollFilePath)) {
            return lines.filter(l -> l != null && !l.isBlank()).count();
        }
    }

    private void ensureParentDirExists() throws IOException {
        Path parent = payrollFilePath.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }
    }
}