package javaProgramingElements.level2;

import java.util.Scanner;

/*
  salary + bonus:
  takes salary and bonus and prints total income.
*/
public class SalaryBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter salary: ");
        int sal = input.nextInt();

        System.out.print("enter bonus: ");
        int bonus = input.nextInt();

        int totalSal = sal + bonus;
        System.out.println("the salary is inr " + sal + " and bonus is inr " + bonus + ". hence total income is inr " + totalSal);

        input.close();
    }
}
