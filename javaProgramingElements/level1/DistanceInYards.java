package javaProgramingElements.level1;

import java.util.Scanner;

/*
  feet -> yards -> miles:
  takes feet input and converts.
*/
public class DistanceInYards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter dist in feet: ");
        double feet = input.nextDouble();

        double yard = feet / 3.0;
        double miles = yard / 1760.0;

        System.out.println("your distance in feet is " + feet + " while in yard is " + yard + " and in miles " + miles);

        input.close();
    }
}
