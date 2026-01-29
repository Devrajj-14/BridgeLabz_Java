package javaMethods.level3;

import java.util.Scanner;

public class NumberCheckerArmstrongDuckLargestSmallest {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int n = Math.abs(number);
        int count = 0;

        // loop for digit count
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

        // storing digits from end
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }

        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        // duck number means has at least one zero digit and number should not start with 0
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;

        // loop for armstrong sum
        for (int i = 0; i < digits.length; i++) {
            sum += (int) Math.pow(digits[i], power);
        }

        return sum == Math.abs(number);
    }

    public static int[] largestSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // loop for largest
        for (int i = 0; i < digits.length; i++) {
            int v = digits[i];
            if (v > largest) {
                second = largest;
                largest = v;
            } else if (v > second && v != largest) {
                second = v;
            }
        }

        if (second == Integer.MIN_VALUE) second = largest;
        return new int[]{largest, second};
    }

    public static int[] smallestSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // loop for smallest
        for (int i = 0; i < digits.length; i++) {
            int v = digits[i];
            if (v < smallest) {
                second = smallest;
                smallest = v;
            } else if (v < second && v != smallest) {
                second = v;
            }
        }

        if (second == Integer.MAX_VALUE) second = smallest;
        return new int[]{smallest, second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("digit count " + digits.length);
        System.out.println("duck number " + isDuckNumber(digits));
        System.out.println("armstrong " + isArmstrong(number, digits));

        int[] big = largestSecondLargest(digits);
        int[] small = smallestSecondSmallest(digits);

        System.out.println("largest " + big[0]);
        System.out.println("second largest " + big[1]);
        System.out.println("smallest " + small[0]);
        System.out.println("second smallest " + small[1]);

        sc.close();
    }
}
