package javaMethods.level3;

import java.util.Scanner;

public class NumberCheckerPrimeNeonSpyAutomorphicBuzz {

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        // loop till sqrt using n / i
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static int sumDigits(int n) {
        n = Math.abs(n);
        int sum = 0;

        // loop for sum digits
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }

    public static boolean isNeon(int n) {
        if (n < 0) return false;
        int sq = n * n;
        return sumDigits(sq) == n;
    }

    public static boolean isSpy(int n) {
        n = Math.abs(n);
        if (n == 0) return false;

        int sum = 0;
        int product = 1;

        // loop for sum and product
        while (n > 0) {
            int d = n % 10;
            sum += d;
            product *= d;
            n = n / 10;
        }

        return sum == product;
    }

    public static boolean isAutomorphic(int n) {
        if (n < 0) return false;

        long sq = (long) n * n;

        // check ending digits
        int temp = n;
        while (temp > 0) {
            if (temp % 10 != sq % 10) return false;
            temp = temp / 10;
            sq = sq / 10;
        }

        return true;
    }

    public static boolean isBuzz(int n) {
        n = Math.abs(n);
        return (n % 7 == 0) || (n % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int n = sc.nextInt();

        System.out.println("prime " + isPrime(n));
        System.out.println("neon " + isNeon(n));
        System.out.println("spy " + isSpy(n));
        System.out.println("automorphic " + isAutomorphic(n));
        System.out.println("buzz " + isBuzz(n));

        sc.close();
    }
}
