package Generics;

import java.util.ArrayList;
import java.util.List;

interface Category{}

enum Books implements Category{name , author , price};
enum Clothing implements Category{formal , sports , casual};
enum Gadgets implements Category{mobile , laptop , tablet};

class Product<C extends Category>{
    String name;
    double price;
    C category;
    Product(String name, double price, C category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
    public String toString(){
        return name + price + category;
    }

}
class Catalog{
    List<Product<? extends Category>> list = new ArrayList<>();

    void addProduct(Product<? extends Category>p){
        list.add(p);
    }
    void showAll(){
        for(Product<? extends Category>p: list){
            System.out.println(p);
        }
    }
}
class Discount{
    static <T extends Product<? extends Category>> void applyDiscount(T product ,double percent ){
        product.price= product.price-(product.price*percent/100.0);
    }
}

public class DynamicMarketPlace {
    public static void main(String[] args){
        Product<Books> book = new Product<>("Atomic Habits", 499, Books.author);
        Product<Clothing> tshirt = new Product<>("T-Shirt", 799, Clothing.casual);
        Product<Gadgets> earbuds = new Product<>("Earbuds", 1999, Gadgets.mobile);

        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(earbuds);

        Discount.applyDiscount(book, 10);
        Discount.applyDiscount(tshirt, 20);
        Discount.applyDiscount(earbuds, 5);

        catalog.showAll();
    }
}
