package EncapsulationPolymorphismEtc;

import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetail();
}

abstract class Vehicle {
    private int vehicleNumber;
    private String type;
    private double rentalRate; // per day

    Vehicle(int vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public int getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(int vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public void display() {
        System.out.println("Vehicle No: " + vehicleNumber + " | Type: " + type + " | Rate/day: " + rentalRate);
    }

    public abstract double calculateRentalCost();
}

class Bike extends Vehicle implements Insurable {
    private int days;

    Bike(int vehicleNumber, String type, double rentalRate, int days) {
        super(vehicleNumber, type, rentalRate);
        this.days = days;
    }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }

    @Override
    public double calculateRentalCost() {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost() * 0.02; // 2% of rental cost
    }

    @Override
    public String getInsuranceDetail() {
        return "Bike Insurance: 2% of rental cost";
    }
}

class Car extends Vehicle implements Insurable {
    private int days;

    Car(int vehicleNumber, String type, double rentalRate, int days) {
        super(vehicleNumber, type, rentalRate);
        this.days = days;
    }

    @Override
    public double calculateRentalCost() {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost() * 0.05; // 5% of rental cost
    }

    @Override
    public String getInsuranceDetail() {
        return "Car Insurance: 5% of rental cost";
    }
}

class Truck extends Vehicle implements Insurable {
    private int days;

    Truck(int vehicleNumber, String type, double rentalRate, int days) {
        super(vehicleNumber, type, rentalRate);
        this.days = days;
    }

    @Override
    public double calculateRentalCost() {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost() * 0.08; // 8% of rental cost
    }

    @Override
    public String getInsuranceDetail() {
        return "Truck Insurance: 8% of rental cost";
    }
}

public class VehicleRental {

    static void printBill(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            double rent = v.calculateRentalCost();

            double insurance = 0;
            String info = "No Insurance";

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                insurance = i.calculateInsurance();
                info = i.getInsuranceDetail();
            }

            double total = rent + insurance;

            v.display();
            System.out.println("Rental Cost: " + rent);
            System.out.println("Insurance: " + insurance + " (" + info + ")");
            System.out.println("Total: " + total);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();

        list.add(new Bike(101, "Bike", 300, 3));
        list.add(new Car(201, "Car", 1200, 2));
        list.add(new Truck(301, "Truck", 2500, 1));

        printBill(list); // polymorphism
    }
}
