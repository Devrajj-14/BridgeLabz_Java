package javaMethods.level1;

import java.util.Scanner;

/*
this program takes principal rate and time and calculates simple interest
it uses a method so the main stays clean
*/
public class SimpleInterestCalculator {

    // method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter principal ");
        double principal = sc.nextDouble();

        System.out.print("enter rate ");
        double rate = sc.nextDouble();

        System.out.print("enter time ");
        double time = sc.nextDouble();

        // validation for wrong values
        if (principal < 0 || rate < 0 || time < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        double si = calculateSimpleInterest(principal, rate, time);

        System.out.println("the simple interest is " + si + " for principal " + principal + " rate of interest " + rate + " and time " + time);

        sc.close();
    }
}
