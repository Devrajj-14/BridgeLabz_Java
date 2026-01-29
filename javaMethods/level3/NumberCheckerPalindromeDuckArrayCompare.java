package javaMethods.level3;

import java.util.Scanner;

public class NumberCheckerPalindromeDuckArrayCompare {

    public static int[] storeDigits(int number) {
        int n = Math.abs(number);
        if (n == 0) return new int[]{0};

        int temp = n;
        int count = 0;

        // count digits
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];

        // store digits
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }

        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];

        // loop for reverse
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }

        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        // loop to compare
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] rev = reverseArray(digits);
        return arraysEqual(digits, rev);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);
        int[] rev = reverseArray(digits);

        System.out.println("duck number " + isDuckNumber(digits));
        System.out.println("palindrome " + arraysEqual(digits, rev));

        sc.close();
    }
}
