package javaMethods.level2;

import java.util.Scanner;

/*
this program takes 5 numbers
checks positive or negative
for positive checks even or odd
then compares first and last number
*/
public class NumberTypeEvenOddCompareMethods {

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // returns 1 if a > b, 0 if equal, -1 if a < b
    public static int compare(int number1, int number2) {
        if (number1 > number2) return 1;
        if (number1 < number2) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        // loop for input
        for (int i = 0; i < arr.length; i++) {
            System.out.print("enter number ");
            arr[i] = sc.nextInt();
        }

        // loop for checks
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];

            // positive negative logic
            if (isPositive(n)) {
                // even odd logic
                if (isEven(n)) {
                    System.out.println(n + " positive even");
                } else {
                    System.out.println(n + " positive odd");
                }
            } else if (n < 0) {
                System.out.println(n + " negative");
            } else {
                System.out.println(n + " zero");
            }
        }

        int cmp = compare(arr[0], arr[arr.length - 1]);

        // printing compare result
        if (cmp == 0) {
            System.out.println("first and last are equal");
        } else if (cmp == 1) {
            System.out.println("first is greater than last");
        } else {
            System.out.println("first is less than last");
        }

        sc.close();
    }
}
