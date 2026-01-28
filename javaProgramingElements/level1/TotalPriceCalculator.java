package javaProgramingElements.level1;

import java.util.Scanner;

/*
  total price:
  takes unit price and quantity, prints total.
*/
public class TotalPriceCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter unit price: ");
        int unitPrice = input.nextInt();

        System.out.print("enter quantity: ");
        int quantity = input.nextInt();

        int totalPrice = unitPrice * quantity;
        System.out.println("the total purchase price is inr " + totalPrice + " if the quantity is " + quantity + " and unit price is inr " + unitPrice);

        input.close();
    }
}
