package javaProgramingElements.level1;

import java.util.Scanner;

/*
  km to miles:
  takes km input and converts to miles.
*/
public class KilometersToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter dist in km: ");
        double km = input.nextDouble();

        double miles = km * 0.62;
        System.out.println("the total miles is " + miles + " mile for the given " + km + " km");

        input.close();
    }
}
