package EncapsulationPolymorphismEtc;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Subclasses
class InPatient extends Patient {
    public InPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    public double calculateBill() {
        return 5000.0;  // Example billing for In-Patient
    }
}

class OutPatient extends Patient {
    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    public double calculateBill() {
        return 1000.0;  // Example billing for Out-Patient
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// Example class demonstrating polymorphism
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 30);
        Patient outPatient = new OutPatient("P002", "Jane Doe", 28);

        System.out.println(inPatient.getPatientDetails() + ", Bill: " + inPatient.calculateBill());
        System.out.println(outPatient.getPatientDetails() + ", Bill: " + outPatient.calculateBill());
    }
}
