package javaMethods.level1;

import java.util.Scanner;

/*
this program calculates sin cos and tan for an angle in degrees
it converts degrees to radians and then uses math functions
*/
public class TrigonometryCalculator {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double rad = Math.toRadians(angle);
        double sin = Math.sin(rad);
        double cos = Math.cos(rad);
        double tan = Math.tan(rad);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter angle in degrees ");
        double angle = sc.nextDouble();

        double[] res = calculateTrigonometricFunctions(angle);

        System.out.println("sin " + res[0]);
        System.out.println("cos " + res[1]);
        System.out.println("tan " + res[2]);

        sc.close();
    }
}
