package javaMethods.level2;

import java.util.Scanner;

/*
this program finds factors and stores them in an array
then it prints sum sum of squares and product using separate methods
*/
public class FactorsAndOperations {

    public static int[] findFactors(int number) {
        int count = 0;

        // first loop counts factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        // second loop stores factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;

        // loop for sum
        for (int i = 0; i < factors.length; i++) {
            sum = sum + factors[i];
        }

        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;

        // loop for product
        for (int i = 0; i < factors.length; i++) {
            product = product * factors[i];
        }

        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sumSq = 0;

        // loop for sum of squares
        for (int i = 0; i < factors.length; i++) {
            sumSq = sumSq + Math.pow(factors[i], 2);
        }

        return sumSq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter a number ");
        int number = sc.nextInt();

        // validation for positive number
        if (number <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        int[] factors = findFactors(number);

        // printing factors
        for (int i = 0; i < factors.length; i++) {
            System.out.println(factors[i]);
        }

        int sum = findSum(factors);
        long product = findProduct(factors);
        double sumSq = findSumOfSquares(factors);

        System.out.println("sum " + sum);
        System.out.println("product " + product);
        System.out.println("sum of squares " + sumSq);

        sc.close();
    }
}
