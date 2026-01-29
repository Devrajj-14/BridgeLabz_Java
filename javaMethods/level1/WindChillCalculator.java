package javaMethods.level1;

import java.util.Scanner;

/*
this program calculates wind chill using the given formula
it uses a method to compute wind chill from temperature and wind speed
*/
public class WindChillCalculator {

    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter temperature ");
        double temperature = sc.nextDouble();

        System.out.print("enter wind speed ");
        double windSpeed = sc.nextDouble();

        // validation for wind speed and temperature
        if (windSpeed < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        double chill = calculateWindChill(temperature, windSpeed);

        System.out.println(chill);

        sc.close();
    }
}
