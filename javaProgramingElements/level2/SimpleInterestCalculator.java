package javaProgramingElements.level2;

import java.util.Scanner;

/*
  simple interest:
  si = principal * rate * time / 100
*/
public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter principal: ");
        int principal = input.nextInt();

        System.out.print("enter rate: ");
        int rate = input.nextInt();

        System.out.print("enter time: ");
        int time = input.nextInt();

        int simpleInterest = principal * rate * time / 100;
        System.out.println("the simple interest is " + simpleInterest + " for principal " + principal + " rate of interest " + rate + " and time " + time);

        input.close();
    }
}
