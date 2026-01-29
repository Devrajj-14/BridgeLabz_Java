package javaMethods.level1;

import java.util.Scanner;

/*
this program finds sum of n natural numbers using a loop
it uses a method so calculation is separate
*/
public class SumOfNNaturalNumbersLoop {

    // method to calculate sum using loop
    public static long sumUsingLoop(int n) {
        long sum = 0;

        // loop for sum
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter n ");
        int n = sc.nextInt();

        // validation for natural number
        if (n <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        long sum = sumUsingLoop(n);

        System.out.println(sum);

        sc.close();
    }
}
