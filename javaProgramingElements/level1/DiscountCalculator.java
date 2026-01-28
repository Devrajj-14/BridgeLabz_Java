package javaProgramingElements.level1;

/*
  discount calculator:
  applies 10% discount on fees like your sample.
*/
public class DiscountCalculator {
    public static void main(String[] args) {
        int univFees = 125000;
        int discountPercent = 10;

        int discountAmount = (univFees * discountPercent) / 100;
        int finalFees = univFees - discountAmount;

        System.out.println("the discount amount is inr " + discountAmount + " and final discounted fee is inr " + finalFees);
    }
}
