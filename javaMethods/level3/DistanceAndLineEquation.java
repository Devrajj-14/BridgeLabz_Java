package javaMethods.level3;

import java.util.Scanner;

public class DistanceAndLineEquation {

    public static double findDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    // returns array m and b for y = m*x + b
    // for vertical line returns empty array
    public static double[] findSlopeIntercept(double x1, double y1, double x2, double y2) {
        if (x2 == x1) return new double[0];

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);

        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter x1 ");
        double x1 = sc.nextDouble();
        System.out.print("enter y1 ");
        double y1 = sc.nextDouble();

        System.out.print("enter x2 ");
        double x2 = sc.nextDouble();
        System.out.print("enter y2 ");
        double y2 = sc.nextDouble();

        double dist = findDistance(x1, y1, x2, y2);
        System.out.println("distance " + dist);

        double[] line = findSlopeIntercept(x1, y1, x2, y2);

        // handling vertical line
        if (line.length == 0) {
            System.out.println("line is vertical");
            System.out.println("equation x = " + x1);
        } else {
            System.out.println("slope " + line[0]);
            System.out.println("intercept " + line[1]);
            System.out.println("equation y = " + line[0] + " * x + " + line[1]);
        }

        sc.close();
    }
}
