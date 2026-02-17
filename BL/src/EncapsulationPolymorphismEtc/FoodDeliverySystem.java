package EncapsulationPolymorphismEtc;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Subclasses
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private static final double ADDITIONAL_CHARGE = 2.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + ADDITIONAL_CHARGE;
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double price);
    String getDiscountDetails();
}

// Example class demonstrating polymorphism
public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Veg Pizza", 10.0, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Burger", 5.0, 3);

        System.out.println(vegItem.getItemDetails() + ", Total Price: " + vegItem.calculateTotalPrice());
        System.out.println(nonVegItem.getItemDetails() + ", Total Price: " + nonVegItem.calculateTotalPrice());
    }
}