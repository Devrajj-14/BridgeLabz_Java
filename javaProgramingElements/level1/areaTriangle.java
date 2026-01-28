package javaProgramingElements.level1;

import java.util.Scanner;

/*
  area of triangle:
  takes base and height in cm, converts to feet/inches, prints triangle area.
*/
public class areaTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter base in cm: ");
        double cmBase = input.nextDouble();

        System.out.print("enter height in cm: ");
        double cmHeight = input.nextDouble();

        double feetBase = cmBase / 30.48;
        double feetHeight = cmHeight / 30.48;

        double inchesBase = cmBase * 0.3937;
        double inchesHeight = cmHeight * 0.3937;

        double areaInSquareFeet = 0.5 * feetBase * feetHeight;
        double areaInSquareInches = 0.5 * inchesBase * inchesHeight;

        System.out.println("height in feet: " + feetHeight + ", height in inches: " + inchesHeight);
        System.out.println("area in square inches: " + areaInSquareInches + ", area in square feet: " + areaInSquareFeet);

        input.close();
    }
}
