package javaProgramingElements.level2;

import java.util.Scanner;

/*
  abc double operations:
  takes a, b, c and prints results for different expressions.
*/
public class DoubleOperationsABC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter val of a: ");
        double a = input.nextDouble();

        System.out.print("enter val of b: ");
        double b = input.nextDouble();

        System.out.print("enter val of c: ");
        double c = input.nextDouble();

        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;  // b should not be 0 ideally
        double op4 = a % b + c;  // modulo works for double too

        System.out.println("the results are " + op1 + ", " + op2 + ", " + op3 + " and " + op4);

        input.close();
    }
}
