package javaProgramingElements.level2;

import java.util.Scanner;

/*
  swap two numbers:
  swaps using temp variable.
*/
public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter num1: ");
        int num1 = input.nextInt();

        System.out.print("enter num2: ");
        int num2 = input.nextInt();

        int temp = num1; // temp stores num1
        num1 = num2;
        num2 = temp;

        System.out.println("the swapped numbers are " + num1 + " and " + num2);

        input.close();
    }
}
