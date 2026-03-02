package com.bridgelabz.fileio;

import java.util.Objects;

public class EmployeePayrollData {
    private final int id;
    private final String name;
    private final double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        this.id = id;
        this.name = name.trim();
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    // File format: id,name,salary
    public String toCsvLine() {
        return id + "," + name + "," + salary;
    }

    public static EmployeePayrollData fromCsvLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid line: " + line);
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        double salary = Double.parseDouble(parts[2].trim());
        return new EmployeePayrollData(id, name, salary);
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePayrollData that)) return false;
        return id == that.id && Double.compare(that.salary, salary) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}