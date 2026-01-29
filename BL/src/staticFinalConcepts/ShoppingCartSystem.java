package staticFinalConcepts;

public class ShoppingCartSystem {

    static double discount = 10.0; // shared discount percentage for all products

    private final int productID;   // final: cannot change after constructor
    private String productName;
    private double price;
    private int quantity;

    /*
     * Class: ShoppingCartSystem
     * Purpose: Demonstrates static, this, final, instanceof in one program.
     */
    public ShoppingCartSystem(int productID, String productName, double price, int quantity) {
        this.productID = productID;       // final assigned once
        this.productName = productName;   // this resolves ambiguity
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
        }
    }

    public double getTotalPriceAfterDiscount() {
        double total = price * quantity;
        double discountAmount = total * (discount / 100.0);
        return total - discountAmount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount(%): " + discount);
        System.out.println("Total After Discount: " + getTotalPriceAfterDiscount());
    }

    public static void safeProcess(Object obj) {
        if (obj instanceof ShoppingCartSystem) { // instanceof check
            ((ShoppingCartSystem) obj).displayDetails();
        } else {
            System.out.println("Not a Product object.");
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem p1 = new ShoppingCartSystem(501, "Notebook", 50.0, 3);
        ShoppingCartSystem p2 = new ShoppingCartSystem(502, "Pen", 10.0, 10);

        ShoppingCartSystem.safeProcess(p1);
        System.out.println();

        ShoppingCartSystem.updateDiscount(20);
        ShoppingCartSystem.safeProcess(p2);
        System.out.println();

        ShoppingCartSystem.safeProcess("hello");//to check if instanceof is working properly
    }
}
