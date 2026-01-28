package javaProgramingElements.level1;

import java.util.Scanner;

/*
  cm to feet and inches:
  takes height in cm and prints feet + inches.
*/
public class FeetToInches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter height in cm: ");
        double cm = input.nextDouble();

        double feet = cm / 30.48;
        double inches = cm * 0.3937;

        System.out.println("your height in cm is " + cm + " while in feet is " + feet + " and inches is " + inches);

        input.close();
    }
}
