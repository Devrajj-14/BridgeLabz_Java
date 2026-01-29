package staticFinalConcepts;

public class VehicleRegistrationSytem {

    static double registrationFee = 2500.0;   // shared for all vehicles

    private final String registrationNumber;  // final: cannot be changed
    private String ownerName;
    private String vehicleType;

    /*
     * Class: VehicleRegistrationSytem
     * Purpose: Demonstrates static, this, final, instanceof
     */
    public VehicleRegistrationSytem(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;                 // this resolves ambiguity
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // final assigned once
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
        }
    }

    public void displayDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void safeDisplay(Object obj) {
        if (obj instanceof VehicleRegistrationSytem) {   // instanceof check
            ((VehicleRegistrationSytem) obj).displayDetails();
        } else {
            System.out.println("Not a Vehicle object.");
        }
    }

    public static void main(String[] args) {
        VehicleRegistrationSytem v1 =
                new VehicleRegistrationSytem("Devraj", "Car", "TN10AB1234");

        VehicleRegistrationSytem v2 =
                new VehicleRegistrationSytem("Rahul", "Bike", "TN22CD5678");

        VehicleRegistrationSytem.safeDisplay(v1);
        System.out.println();

        VehicleRegistrationSytem.updateRegistrationFee(3000);
        VehicleRegistrationSytem.safeDisplay(v2);
        System.out.println();

        VehicleRegistrationSytem.safeDisplay(123);
    }
}
