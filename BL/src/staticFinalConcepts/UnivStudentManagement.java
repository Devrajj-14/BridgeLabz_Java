package staticFinalConcepts;

public class UnivStudentManagement {

    static String universityName = "SRM University";
    private static int totalStudents = 0;

    private final int rollNumber;   // final: cannot change after constructor
    private String name;
    private char grade;

    /*
     * Class: UnivStudentManagement
     * Purpose: Demonstrates static, this, final, instanceof in one program.
     */
    public UnivStudentManagement(String name, int rollNumber, char grade) {
        this.name = name;                 // this resolves ambiguity
        this.rollNumber = rollNumber;     // final assigned once
        this.grade = grade;

        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("University Name: " + universityName);
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public void updateGrade(char newGrade) {
        this.grade = newGrade;
    }

    public static void safeDisplay(Object obj) {
        if (obj instanceof UnivStudentManagement) {   // instanceof check
            ((UnivStudentManagement) obj).displayDetails();
        } else {
            System.out.println("Not a Student object.");
        }
    }

    public static void safeUpdateGrade(Object obj, char newGrade) {
        if (obj instanceof UnivStudentManagement) {   // instanceof check
            ((UnivStudentManagement) obj).updateGrade(newGrade);
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Not a Student object. Grade cannot be updated.");
        }
    }

    public static void main(String[] args) {
        UnivStudentManagement s1 = new UnivStudentManagement("Devraj", 1, 'A');
        UnivStudentManagement s2 = new UnivStudentManagement("Rahul", 2, 'B');

        UnivStudentManagement.displayTotalStudents();

        UnivStudentManagement.safeDisplay(s1);
        System.out.println();

        UnivStudentManagement.safeUpdateGrade(s2, 'A');
        UnivStudentManagement.safeDisplay(s2);
        System.out.println();

        UnivStudentManagement.safeUpdateGrade("hello", 'C');
    }
}
