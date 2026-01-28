package javaProgramingElements.level2;

import java.util.Scanner;

/*
  temperature conversion advanced:
  converts fahrenheit to celsius.
*/
public class TemperatureConversionAdvanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter temp in fahrenheit: ");
        double fTemp = input.nextDouble();

        double cTemp = (fTemp - 32) * 5 / 9.0;
        System.out.println("the " + fTemp + " fahrenheit is " + cTemp + " celsius");

        input.close();
    }
}
