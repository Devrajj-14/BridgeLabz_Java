package javaMethods.level2;

import java.util.Scanner;

/*
unit converter for yards feet inches cm meters
all methods are static
*/
public class UnitConverterYardsFeetInchesCm {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter yards ");
        double yards = sc.nextDouble();

        System.out.print("enter feet ");
        double feet = sc.nextDouble();

        System.out.print("enter meters ");
        double meters = sc.nextDouble();

        System.out.print("enter inches ");
        double inches = sc.nextDouble();

        // validation
        if (yards < 0 || feet < 0 || meters < 0 || inches < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        System.out.println("yards to feet " + convertYardsToFeet(yards));
        System.out.println("feet to yards " + convertFeetToYards(feet));
        System.out.println("meters to inches " + convertMetersToInches(meters));
        System.out.println("inches to meters " + convertInchesToMeters(inches));
        System.out.println("inches to cm " + convertInchesToCentimeters(inches));

        sc.close();
    }
}
