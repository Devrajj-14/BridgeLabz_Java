package javaMethods.level1;

import java.util.Scanner;

/*
this program divides chocolates among children
it uses the same method signature used for remainder and quotient
*/
public class ChocolateDistributionCalculator {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number of chocolates ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("enter number of children ");
        int numberOfChildren = sc.nextInt();

        // validation for wrong values
        if (numberOfChocolates < 0 || numberOfChildren <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        int[] res = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("each child gets " + res[0]);
        System.out.println("remaining chocolates " + res[1]);

        sc.close();
    }
}
