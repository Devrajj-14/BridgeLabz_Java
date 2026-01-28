package javaProgramingElements.level1;

import java.util.Scanner;

/*
  percentage calculator:
  takes 3 subject marks and prints percentage.
*/
public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter marks in physics: ");
        int physics = input.nextInt();

        System.out.print("enter marks in chemistry: ");
        int chemistry = input.nextInt();

        System.out.print("enter marks in maths: ");
        int maths = input.nextInt();

        double percentage = (physics + chemistry + maths) / 3.0;
        System.out.println("percentage is: " + percentage);

        input.close();
    }
}
