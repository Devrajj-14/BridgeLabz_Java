package javaMethods.level2;

import java.util.Scanner;

/*
unit converter for temperature weight and volume
all methods are static
*/
public class UnitConverterTempWeightVolume {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9.0;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5.0) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter farhenheit ");
        double f = sc.nextDouble();

        System.out.print("enter celsius ");
        double c = sc.nextDouble();

        System.out.print("enter pounds ");
        double pounds = sc.nextDouble();

        System.out.print("enter kilograms ");
        double kg = sc.nextDouble();

        System.out.print("enter gallons ");
        double gallons = sc.nextDouble();

        System.out.print("enter liters ");
        double liters = sc.nextDouble();

        // validation for negative where it makes sense
        if (pounds < 0 || kg < 0 || gallons < 0 || liters < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        System.out.println("f to c " + convertFarhenheitToCelsius(f));
        System.out.println("c to f " + convertCelsiusToFarhenheit(c));
        System.out.println("pounds to kg " + convertPoundsToKilograms(pounds));
        System.out.println("kg to pounds " + convertKilogramsToPounds(kg));
        System.out.println("gallons to liters " + convertGallonsToLiters(gallons));
        System.out.println("liters to gallons " + convertLitersToGallons(liters));

        sc.close();
    }
}
