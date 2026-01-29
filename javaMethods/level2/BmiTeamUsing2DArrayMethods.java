 package javaMethods.level2;

import java.util.Scanner;

/*
this program takes weight and height for 10 people
stores weight height and bmi in a 2d array
then prints bmi status for each person
*/
public class BmiTeamUsing2DArrayMethods {

    public static void fillBmi(double[][] data) {
        // loop to calculate bmi
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            data[i][2] = bmi;
        }
    }

    public static String getStatus(double bmi) {
        // bmi status logic
        if (bmi < 18.5) return "underweight";
        if (bmi < 25) return "normal";
        if (bmi < 30) return "overweight";
        return "obese";
    }

    public static String[] getAllStatuses(double[][] data) {
        String[] status = new String[data.length];

        // loop to create status array
        for (int i = 0; i < data.length; i++) {
            status[i] = getStatus(data[i][2]);
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];

        // loop to take input
        for (int i = 0; i < data.length; i++) {
            System.out.print("enter weight in kg ");
            double weight = sc.nextDouble();

            System.out.print("enter height in cm ");
            double height = sc.nextDouble();

            // validation
            if (weight <= 0 || height <= 0) {
                System.out.println("invalid input");
                sc.close();
                return;
            }

            data[i][0] = weight;
            data[i][1] = height;
        }

        fillBmi(data);
        String[] status = getAllStatuses(data);

        // printing result
        for (int i = 0; i < data.length; i++) {
            System.out.println("person " + (i + 1) + " weight " + data[i][0] + " height " + data[i][1] + " bmi " + data[i][2] + " status " + status[i]);
        }

        sc.close();
    }
}
