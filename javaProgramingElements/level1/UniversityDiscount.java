package javaProgramingElements.level1;

import java.util.Scanner;

/*
  university discount:
  takes fee and discount percentage and prints discounted amount + final fee.
*/
public class UniversityDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter fee: ");
        int fee = input.nextInt();

        System.out.print("enter discount (%): ");
        double discount = input.nextDouble();

        double discountedAmount = (fee * discount) / 100.0;
        double finalFee = fee - discountedAmount;

        System.out.println("the discount amount is inr " + discountedAmount + " and final discounted fee is inr " + finalFee);

        input.close();
    }
}
