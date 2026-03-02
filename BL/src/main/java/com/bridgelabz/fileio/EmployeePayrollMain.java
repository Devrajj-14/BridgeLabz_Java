package com.bridgelabz.fileio;

import java.nio.file.Path;
import java.util.Scanner;

public class EmployeePayrollMain {
    public static void main(String[] args) throws Exception {
        Path payrollFile = Path.of("data", "employee-payroll.txt");
        EmployeePayrollService service = new EmployeePayrollService(payrollFile);

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Employee Payroll (UC1) ===");
        service.readEmployeePayrollData(sc);
        service.writeEmployeePayrollData(IOService.CONSOLE_IO);

        // Optional: write to file and show count (UC4/UC5)
        service.writeEmployeePayrollDataToFile();
        System.out.println("Entries in file: " + service.countEntriesInFile());
    }
}