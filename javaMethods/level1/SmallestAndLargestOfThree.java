package javaMethods.level1;

import java.util.Scanner;

/*
this program finds smallest and largest among 3 numbers using one method
method returns an int array with smallest at index 0 and largest at index 1
*/
public class SmallestAndLargestOfThree {

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        // checking largest
        if (number2 > largest) largest = number2;
        if (number3 > largest) largest = number3;

        // checking smallest
        if (number2 < smallest) smallest = number2;
        if (number3 < smallest) smallest = number3;

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number1 ");
        int number1 = sc.nextInt();

        System.out.print("enter number2 ");
        int number2 = sc.nextInt();

        System.out.print("enter number3 ");
        int number3 = sc.nextInt();

        int[] res = findSmallestAndLargest(number1, number2, number3);

        System.out.println("smallest " + res[0]);
        System.out.println("largest " + res[1]);

        sc.close();
    }
}
