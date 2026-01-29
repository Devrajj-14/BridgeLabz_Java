package javaMethods.level3;

import java.util.Scanner;

public class NumberCheckerHarshadSumSquaresFrequency {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int n = Math.abs(number);
        int count = 0;

        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public static int[] storeDigits(int number) {
        int n = Math.abs(number);
        int count = countDigits(n);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }

        return digits;
    }

    public static int sumDigits(int[] digits) {
        int sum = 0;

        // loop for sum
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }

        return sum;
    }

    public static double sumSquaresDigits(int[] digits) {
        double sum = 0;

        // loop for sum of squares
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], 2);
        }

        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumDigits(digits);
        if (sum == 0) return false;
        return Math.abs(number) % sum == 0;
    }

    // 2d array digit and freq
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        // init digit column
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        // count frequency
        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        int sum = sumDigits(digits);
        double sumSq = sumSquaresDigits(digits);
        boolean harshad = isHarshad(number, digits);

        System.out.println("sum of digits " + sum);
        System.out.println("sum of squares " + sumSq);
        System.out.println("harshad " + harshad);

        int[][] freq = digitFrequency(digits);

        // printing frequency for digits that appear
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println("digit " + freq[i][0] + " frequency " + freq[i][1]);
            }
        }

        sc.close();
    }
}
