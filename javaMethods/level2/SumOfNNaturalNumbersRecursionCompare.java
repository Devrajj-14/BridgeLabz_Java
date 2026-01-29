package javaMethods.level2;

import java.util.Scanner;

/*
this program finds sum of n natural numbers using recursion
it also finds sum using formula and compares both
*/
public class SumOfNNaturalNumbersRecursionCompare {

    public static long sumUsingRecursion(int n) {
        if (n == 0) return 0;
        return n + sumUsingRecursion(n - 1);
    }

    public static long sumUsingFormula(int n) {
        return (long) n * (n + 1) / 2;
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

        long rec = sumUsingRecursion(n);
        long formula = sumUsingFormula(n);

        System.out.println("recursion sum " + rec);
        System.out.println("formula sum " + formula);

        // comparing both results
        if (rec == formula) {
            System.out.println("both are same");
        } else {
            System.out.println("not same");
        }

        sc.close();
    }
}
