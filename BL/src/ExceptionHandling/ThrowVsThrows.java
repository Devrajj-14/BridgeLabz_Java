package ExceptionHandling;

import java.util.Scanner;

public class ThrowVsThrows {

    // throws -> method tells caller it may throw an exception
    static void check(double amount, double rate, int year) throws Exception {

        // throw -> actually throws the exception
        if (amount < 0 || rate < 0 || year <= 0) {
            throw new IllegalArgumentException("Invalid amount/rate/year");
        } else {
            System.out.println("Successful");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter year: ");
            int year = sc.nextInt();

            check(amount, rate, year);  // calling method that "throws"

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            // fallback (for any other unexpected exception)
            System.out.println("Something went wrong: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}