package javaProgramingElements.level2;

import java.util.Scanner;

/*
  perimeter of triangle + rounds for 5km:
  takes 3 sides (meters), finds perimeter and how many rounds to complete 5000m.
*/
public class PerimeterOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter side1 (meters): ");
        double side1 = input.nextDouble();

        System.out.print("enter side2 (meters): ");
        double side2 = input.nextDouble();

        System.out.print("enter side3 (meters): ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;

        if (perimeter <= 0) {
            System.out.println("invalid sides");
            input.close();
            return;
        }

        double rounds = 5000.0 / perimeter; // 5km = 5000m
        System.out.println("perimeter is: " + perimeter + " meters");
        System.out.println("rounds needed to complete 5 km: " + rounds);

        input.close();
    }
}
