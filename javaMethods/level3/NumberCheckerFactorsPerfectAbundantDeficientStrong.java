package javaMethods.level3;

import java.util.Scanner;

public class NumberCheckerFactorsPerfectAbundantDeficientStrong {

    public static int[] findFactors(int number) {
        int count = 0;

        // first loop counts
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int idx = 0;

        // second loop stores
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[idx] = i;
                idx++;
            }
        }

        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;

        // loop for max
        for (int i = 0; i < factors.length; i++) {
            if (factors[i] > max) max = factors[i];
        }

        return max;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;

        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }

        return sum;
    }

    public static long productFactors(int[] factors) {
        long product = 1;

        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }

        return product;
    }

    public static double productCubeFactors(int[] factors) {
        double product = 1;

        for (int i = 0; i < factors.length; i++) {
            product *= Math.pow(factors[i], 3);
        }

        return product;
    }

    public static int sumProperDivisors(int number) {
        if (number <= 1) return 0;

        int sum = 1;

        // loop to sum proper divisors
        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                sum += i;
                int other = number / i;
                if (other != i && other != number) sum += other;
            }
        }

        return sum;
    }

    public static boolean isPerfect(int number) {
        if (number <= 1) return false;
        return sumProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        if (number <= 1) return false;
        return sumProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        if (number <= 1) return false;
        return sumProperDivisors(number) < number;
    }

    public static long factorial(int n) {
        long fact = 1;

        // loop for factorial
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static boolean isStrong(int number) {
        if (number < 0) return false;

        int n = number;
        long sum = 0;

        // loop for factorial digit sum
        while (n > 0) {
            int d = n % 10;
            sum += factorial(d);
            n = n / 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        int[] factors = findFactors(number);

        // print factors
        for (int i = 0; i < factors.length; i++) {
            System.out.println(factors[i]);
        }

        System.out.println("greatest factor " + greatestFactor(factors));
        System.out.println("sum factors " + sumFactors(factors));
        System.out.println("product factors " + productFactors(factors));
        System.out.println("product cube factors " + productCubeFactors(factors));

        System.out.println("perfect " + isPerfect(number));
        System.out.println("abundant " + isAbundant(number));
        System.out.println("deficient " + isDeficient(number));
        System.out.println("strong " + isStrong(number));

        sc.close();
    }
}
