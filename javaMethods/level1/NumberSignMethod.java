package javaMethods.level1;

import java.util.Scanner;

/*
this program checks if a number is positive negative or zero using a method
method returns 1 for positive -1 for negative 0 for zero
*/
public class NumberSignMethod {

    // method to return sign value
    public static int checkNumberSign(int num) {
        if (num > 0) return 1;
        if (num < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter a number ");
        int num = sc.nextInt();

        // calling method
        int res = checkNumberSign(num);

        System.out.println(res);

        sc.close();
    }
}
