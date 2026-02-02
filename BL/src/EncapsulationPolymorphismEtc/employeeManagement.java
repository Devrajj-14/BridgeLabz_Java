package EncapsulationPolymorphismEtc;

import java.util.Objects;
import java.util.zip.Deflater;
import java.util.*;

interface Department{
    void assignDept(String dept);
    String getDepartmentDetail();
}

abstract class Employee implements Department {
    int employeeId;
    String name;
    int baseSalary;
    String dept;

    Employee(int employeeId, String name, int baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }
    public abstract double  calculateSal();

    public void displayDetails(){
        System.out.println("the name " + name + " with employee id is " + employeeId + " has base salary is " + baseSalary);
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    public void setBaseSalary(int baseSalary){
        this.baseSalary=baseSalary;
    }
    public void assignDept(String dept){
        this.dept=dept;
    }
    public String getDepartmentDetail(){
        return Objects.requireNonNullElse(dept, "na");
    }
}
class FullTime extends Employee{
    FullTime(int employeeId, String name, int baseSalary){
        super(employeeId,name,baseSalary);
    }
    public double calculateSal(){
        return getBaseSalary();
    }

}
class PartTime extends Employee{
    int hour;
    int rate;
    PartTime(int employeeId ,String name, int baseSalary,int hour, int  rate){
        super(employeeId,name,baseSalary);
        this.hour=hour;
        this.rate=rate;
    }
    public double calculateSal(){
        return getBaseSalary() + hour*rate;
    }
}
public class employeeManagement {
    public static void main(String[] args){
        List<Employee> list=new ArrayList<>();
        Employee a=new FullTime(1,"Devraj",50000);
        Employee b=new PartTime(2,"Aman",5000,40,250);
        a.assignDept("IT");
        b.assignDept("HR");
        list.add(a); list.add(b);

        for(Employee e:list) e.displayDetails();
    }
}
