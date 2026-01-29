package javaMethods.level1;

import java.util.Scanner;

/*
this program finds maximum handshakes using a method
the method uses the same formula n * (n - 1) / 2
*/
public class MaximumHandshakesUsingMethod {

    // method for handshake calculation
    public static long calculateHandshakes(int n) {
        return (long) n * (n - 1) / 2;
    }

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

        long handshakes = calculateHandshakes(n);

        System.out.println("maximum handshakes " + handshakes);

        sc.close();
    }
}
