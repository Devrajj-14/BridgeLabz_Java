package javaMethods.level2;

import java.util.Scanner;

/*
this program takes age of 10 students and checks voting eligibility
it uses a method that returns true or false
*/
public class StudentVoteChecker {

    public boolean canStudentVote(int age) {
        // negative age cannot vote
        if (age < 0) return false;

        // 18 or above can vote
        if (age >= 18) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];

        // loop for 10 students
        for (int i = 0; i < ages.length; i++) {
            System.out.print("enter age ");
            ages[i] = sc.nextInt();

            boolean canVote = checker.canStudentVote(ages[i]);

            if (canVote) {
                System.out.println("can vote");
            } else {
                System.out.println("cannot vote");
            }
        }

        sc.close();
    }
}
