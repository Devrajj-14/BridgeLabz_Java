package EncapsulationPolymorphismEtc;

import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();        // returns tax amount
    String getTaxDetails();       // returns tax info
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: getters/setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void display() {
        System.out.println(productId + " | " + name + " | Price: " + price);
    }

    public abstract double calculateDiscount(); // returns discount amount
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics GST: 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    public String getTaxDetails() {
        return "Clothing GST: 12%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ECommerce {

    // Polymorphism: works for any Product type
    static void printFinalPrices(List<Product> products) {
        for (Product p : products) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();

            double tax = 0;
            String taxInfo = "No Tax";

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                taxInfo = t.getTaxDetails();
            }

            double finalPrice = price + tax - discount;

            p.display();
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax + " (" + taxInfo + ")");
            System.out.println("Final Price: " + finalPrice);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Electronics(1, "Laptop", 60000));
        cart.add(new Clothing(2, "Jacket", 3000));
        cart.add(new Groceries(3, "Rice (10kg)", 800));

        printFinalPrices(cart);
    }
}
