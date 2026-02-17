package EncapsulationPolymorphismEtc;
// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }
}

// Subclasses
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.5; // Bike is cheaper per Km
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.2; // Auto has a higher rate
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Example class demonstrating polymorphism
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle car = new Car("V001", "John", 10);
        Vehicle bike = new Bike("V002", "Alice", 5);
        Vehicle auto = new Auto("V003", "Bob", 8);

        System.out.println(car.getVehicleDetails() + ", Fare for 10km: " + car.calculateFare(10));
        System.out.println(bike.getVehicleDetails() + ", Fare for 10km: " + bike.calculateFare(10));
        System.out.println(auto.getVehicleDetails() + ", Fare for 10km: " + auto.calculateFare(10));
    }
}
