package javaProgramingElements.level1;

import java.util.Scanner;

/*
  maximum handshakes:
  uses formula (n*(n-1))/2.
*/
public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter the number of students: ");
        int n = input.nextInt();

        int combination = (n * (n - 1)) / 2;
        System.out.println("the possible maximum handshakes are: " + combination);

        input.close();
    }
}
