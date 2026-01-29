package javaMethods.level2;

import java.util.Scanner;

/*
unit converter for km miles meter feet
all methods are static like utility
*/
public class UnitConverterKmMilesMeterFeet {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter km ");
        double km = sc.nextDouble();

        System.out.print("enter miles ");
        double miles = sc.nextDouble();

        System.out.print("enter meters ");
        double meters = sc.nextDouble();

        System.out.print("enter feet ");
        double feet = sc.nextDouble();

        // simple validation
        if (km < 0 || miles < 0 || meters < 0 || feet < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        System.out.println("km to miles " + convertKmToMiles(km));
        System.out.println("miles to km " + convertMilesToKm(miles));
        System.out.println("meters to feet " + convertMetersToFeet(meters));
        System.out.println("feet to meters " + convertFeetToMeters(feet));

        sc.close();
    }
}
