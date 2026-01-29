package javaMethods.level2;

import java.util.Scanner;

/*
this program checks leap year for gregorian calendar year >= 1582
it uses a method and prints leap year or not leap year
*/
public class LeapYearCheckerUsingMethod {

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;

        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter year ");
        int year = sc.nextInt();

        boolean leap = isLeapYear(year);

        if (year < 1582) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        if (leap) {
            System.out.println("leap year");
        } else {
            System.out.println("not leap year");
        }

        sc.close();
    }
}
