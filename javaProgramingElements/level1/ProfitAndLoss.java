package javaProgramingElements.level1;

/*
  profit and loss:
  calculates profit and profit percentage.
*/
public class ProfitAndLoss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;

        int profit = sellingPrice - costPrice;
        int profitPercentage = (profit * 100) / costPrice;

        System.out.println("the cost price is inr " + costPrice + " and selling price is inr " + sellingPrice);
        System.out.println("the profit is inr " + profit + " and the profit percentage is " + profitPercentage);
    }
}
