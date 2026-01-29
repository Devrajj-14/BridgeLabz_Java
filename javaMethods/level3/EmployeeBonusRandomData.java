package javaMethods.level3;

public class EmployeeBonusRandomData {

    // returns 2d array [10][2] salary years
    public static int[][] generateEmployeeData() {
        int[][] data = new int[10][2];

        // loop for random salary and service
        for (int i = 0; i < data.length; i++) {
            int salary = 10000 + (int) (Math.random() * 90000);
            int years = 1 + (int) (Math.random() * 11); // 1 to 11

            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    // returns 2d array [10][2] newSalary bonus
    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        double[][] result = new double[10][2];

        // loop for bonus calculation
        for (int i = 0; i < data.length; i++) {
            int oldSalary = data[i][0];
            int years = data[i][1];

            double rate;

            // bonus rule
            if (years > 5) rate = 0.05;
            else rate = 0.02;

            double bonus = oldSalary * rate;
            double newSalary = oldSalary + bonus;

            result[i][0] = newSalary;
            result[i][1] = bonus;
        }

        return result;
    }

    public static void displaySummary(int[][] data, double[][] result) {
        double sumOld = 0;
        double sumNew = 0;
        double totalBonus = 0;

        System.out.println("emp\told\tyears\tbonus\tnew");

        // loop for totals and table
        for (int i = 0; i < data.length; i++) {
            int oldSalary = data[i][0];
            int years = data[i][1];
            double newSalary = result[i][0];
            double bonus = result[i][1];

            sumOld += oldSalary;
            sumNew += newSalary;
            totalBonus += bonus;

            System.out.println((i + 1) + "\t" + oldSalary + "\t" + years + "\t" + bonus + "\t" + newSalary);
        }

        System.out.println("sum old " + sumOld);
        System.out.println("sum new " + sumNew);
        System.out.println("total bonus " + totalBonus);
    }

    public static void main(String[] args) {
        int[][] data = generateEmployeeData();
        double[][] result = calculateNewSalaryAndBonus(data);
        displaySummary(data, result);
    }
}
