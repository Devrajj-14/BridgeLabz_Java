package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class WhareHouseItems{
    String name;
    WhareHouseItems(String n){
        name=n;
    }
    public String toString(){
        return name;
    }
}
class Electronics extends WhareHouseItems{

    Electronics(String n) {
        super(n);
    }
}
class Gros extends WhareHouseItems{
    Gros(String n) {
        super(n);
    }

}
class Furniture extends WhareHouseItems{
    Furniture(String n){
        super(n);
    }
}

class Storage <T extends WhareHouseItems>{
    List<T> items = new ArrayList<>();

    void addItem(T item){
        items.add(item);
    }
    List<T> all(){
        return items;
    }
}
class SmartWareHouse{
    static void show (List<? extends WhareHouseItems>laaa){
        for(WhareHouseItems h :laaa){
            System.out.println(h);
        }
    }
}

public class WareHouseManagement {
    public static void main(String[] args) {
        Storage<Electronics> e = new Storage<>();
        e.addItem(new Electronics("Mobile"));
        Storage<Gros> g = new Storage<>();
        g.addItem(new Gros("fruit"));


        SmartWareHouse.show(e.all());
        SmartWareHouse.show(g.all());
    }
}

