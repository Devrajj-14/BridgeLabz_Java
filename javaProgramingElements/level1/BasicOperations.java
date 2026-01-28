package javaProgramingElements.level1;

import java.util.Scanner;

/*
  basic operations:
  takes two numbers and prints add, sub, mul, div (safe divide).
*/
public class BasicOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter num 1: ");
        int num1 = input.nextInt();

        System.out.print("enter num 2: ");
        int num2 = input.nextInt();

        int add = num1 + num2;
        int sub = Math.abs(num1 - num2); // keeping subtraction positive like your logic
        int mul = num1 * num2;

        System.out.println("addition: " + add);
        System.out.println("subtraction (abs): " + sub);
        System.out.println("multiplication: " + mul);

        // division only if possible
        if (num2 != 0) {
            System.out.println("division (num1/num2): " + (num1 / num2));
        } else {
            System.out.println("division not possible because num2 is 0");
        }

        input.close();
    }
}
