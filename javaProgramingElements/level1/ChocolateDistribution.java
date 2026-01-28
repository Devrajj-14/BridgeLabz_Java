package javaProgramingElements.level1;

import java.util.Scanner;

/*
  chocolate distribution:
  divides chocolates among children and prints each share + remaining.
*/
public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter number of chocolates: ");
        int chocolates = input.nextInt();

        System.out.print("enter number of children: ");
        int children = input.nextInt();

        if (children <= 0) {
            System.out.println("invalid children count");
            input.close();
            return;
        }

        int eachGets = chocolates / children;
        int remaining = chocolates % children;

        System.out.println("the number of chocolates each child gets is " + eachGets + " and the number of remaining chocolates are " + remaining);

        input.close();
    }
}
