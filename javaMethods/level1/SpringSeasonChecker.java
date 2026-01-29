package javaMethods.level1;

import java.util.Scanner;

/*
this program checks spring season between march 20 and june 20
it uses a method that returns true or false
*/
public class SpringSeasonChecker {

    // method to check spring season
    public static boolean isSpringSeason(int month, int day) {
        // basic date validation
        if (month < 1 || month > 12 || day < 1 || day > 31) return false;

        // spring season logic
        if (month == 3 && day >= 20) return true;
        if (month == 4 || month == 5) return true;
        if (month == 6 && day <= 20) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter month ");
        int month = sc.nextInt();

        System.out.print("enter day ");
        int day = sc.nextInt();

        // calling method
        boolean spring = isSpringSeason(month, day);

        if (spring) {
            System.out.println("its a spring season");
        } else {
            System.out.println("not a spring season");
        }

        sc.close();
    }
}
