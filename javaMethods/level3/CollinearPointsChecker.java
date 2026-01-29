package javaMethods.level3;

import java.util.Scanner;

public class CollinearPointsChecker {

    // slope based check using cross multiplication to avoid divide by zero
    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // (y2 - y1)/(x2 - x1) == (y3 - y1)/(x3 - x1)
        // cross multiply
        return (long) (y2 - y1) * (x3 - x1) == (long) (y3 - y1) * (x2 - x1);
    }

    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter x1 ");
        int x1 = sc.nextInt();
        System.out.print("enter y1 ");
        int y1 = sc.nextInt();

        System.out.print("enter x2 ");
        int x2 = sc.nextInt();
        System.out.print("enter y2 ");
        int y2 = sc.nextInt();

        System.out.print("enter x3 ");
        int x3 = sc.nextInt();
        System.out.print("enter y3 ");
        int y3 = sc.nextInt();

        boolean slopeCheck = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaCheck = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("collinear by slope " + slopeCheck);
        System.out.println("collinear by area " + areaCheck);

        sc.close();
    }
}
