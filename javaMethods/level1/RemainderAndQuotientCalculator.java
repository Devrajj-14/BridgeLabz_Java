package javaMethods.level1;

import java.util.Scanner;

/*
this program finds quotient and remainder using a method
method returns an int array where quotient is index 0 and remainder is index 1
*/
public class RemainderAndQuotientCalculator {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number ");
        int number = sc.nextInt();

        System.out.print("enter divisor ");
        int divisor = sc.nextInt();

        // validation for divide by zero
        if (divisor == 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        int[] res = findRemainderAndQuotient(number, divisor);

        System.out.println("quotient " + res[0]);
        System.out.println("remainder " + res[1]);

        sc.close();
    }
}
