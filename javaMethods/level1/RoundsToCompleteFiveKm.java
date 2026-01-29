package javaMethods.level1;

import java.util.Scanner;

/*
this program finds how many rounds are needed to complete 5 km in a triangular park
it uses a method to calculate rounds based on perimeter
*/
public class RoundsToCompleteFiveKm {

    // method to calculate rounds needed for 5 km
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter side1 in meters ");
        double side1 = sc.nextDouble();

        System.out.print("enter side2 in meters ");
        double side2 = sc.nextDouble();

        System.out.print("enter side3 in meters ");
        double side3 = sc.nextDouble();

        // validation for sides
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        // simple triangle validation
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            System.out.println("invalid triangle");
            sc.close();
            return;
        }

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("rounds needed " + rounds);

        sc.close();
    }
}
