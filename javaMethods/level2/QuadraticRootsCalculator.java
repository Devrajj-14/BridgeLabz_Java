package javaMethods.level2;

import java.util.Scanner;

/*
this program finds roots of ax2 + bx + c
returns empty array if delta is negative
*/
public class QuadraticRootsCalculator {

    public static double[] findRoots(double a, double b, double c) {
        if (a == 0) return new double[0];

        double delta = (b * b) - (4 * a * c);

        // delta negative no real roots
        if (delta < 0) return new double[0];

        // delta zero single root
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }

        double sqrtDelta = Math.sqrt(delta);
        double root1 = (-b + sqrtDelta) / (2 * a);
        double root2 = (-b - sqrtDelta) / (2 * a);

        return new double[]{root1, root2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter a ");
        double a = sc.nextDouble();

        System.out.print("enter b ");
        double b = sc.nextDouble();

        System.out.print("enter c ");
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) {
            System.out.println("no real roots");
        } else if (roots.length == 1) {
            System.out.println("root " + roots[0]);
        } else {
            System.out.println("root1 " + roots[0]);
            System.out.println("root2 " + roots[1]);
        }

        sc.close();
    }
}
