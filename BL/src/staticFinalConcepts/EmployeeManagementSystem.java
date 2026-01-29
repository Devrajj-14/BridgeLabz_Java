package staticFinalConcepts;

public class EmployeeManagementSystem {

    static String companyName = "Nexora Pvt Ltd";
    static int totalEmployees = 0;

    private final int id;          // final: cannot change after constructor
    private String name;
    private String designation;

    /*
     * Class: EmployeeManagementSystem
     * Purpose: Demonstrates static, this, final, instanceof in one program.
     */
    public EmployeeManagementSystem(String name, int id, String designation) {
        this.name = name;               // this resolves ambiguity
        this.id = id;                   // final assigned once
        this.designation = designation;

        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void safeDisplay(Object obj) {
        if (obj instanceof EmployeeManagementSystem) {   // instanceof check
            ((EmployeeManagementSystem) obj).displayDetails();
        } else {
            System.out.println("Not an Employee object.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem e1 =
                new EmployeeManagementSystem("Devraj", 101, "Software Intern");

        EmployeeManagementSystem e2 =
                new EmployeeManagementSystem("Rahul", 102, "QA Intern");

        EmployeeManagementSystem.displayTotalEmployees();

        EmployeeManagementSystem.safeDisplay(e1);
        System.out.println();
        EmployeeManagementSystem.safeDisplay(e2);
        System.out.println();
        //EmployeeManagementSystem.safeDisplay(123);
        e1.displayDetails();
    }
}
