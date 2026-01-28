package javaProgramingElements.level1;

import java.util.Scanner;

/*
  celsius to fahrenheit:
  converts c -> f.
*/
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter temp in celsius: ");
        double temp = input.nextDouble();

        double fTemp = ((temp * 9) / 5) + 32;
        System.out.println("the " + temp + " celsius is " + fTemp + " fahrenheit");

        input.close();
    }
}
