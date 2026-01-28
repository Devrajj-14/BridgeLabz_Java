package javaProgramingElements.level1;

import java.util.Scanner;

/*
  pounds to kg converter:
  converts pounds to kilograms.
*/
public class WeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter weight in pounds: ");
        double weight = input.nextDouble();

        double kg = weight * 0.453;
        System.out.println("the weight of the person in pound is " + weight + " and in kg is " + kg);

        input.close();
    }
}
