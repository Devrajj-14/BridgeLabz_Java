package javaMethods.level1;

import java.util.Scanner;

/*
this program finds maximum handshakes using the formula
it does not use any separate method
*/
public class MaximumHandshakesFormulaOnly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number of students ");
        int n = sc.nextInt();

        // validation for student count
        if (n < 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        long handshakes = (long) n * (n - 1) / 2;

        System.out.println("maximum handshakes " + handshakes);

        sc.close();
    }
}
