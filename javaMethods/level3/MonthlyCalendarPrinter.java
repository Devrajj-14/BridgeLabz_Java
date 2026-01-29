package javaMethods.level3;

import java.util.Scanner;

public class MonthlyCalendarPrinter {

    public static String getMonthName(int month) {
        String[] months = {
                "january","february","march","april","may","june",
                "july","august","september","october","november","december"
        };
        if (month < 1 || month > 12) return "";
        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month - 1];
    }

    // gregorian first day algorithm returns 0 sun ... 6 sat
    public static int getFirstDay(int month, int year) {
        int m = month;
        int y = year;
        int d = 1;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static void printCalendar(int month, int year) {
        String name = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int first = getFirstDay(month, year);

        System.out.println(name + " " + year);
        System.out.println("sun mon tue wed thu fri sat");

        // first loop for indentation
        for (int i = 0; i < first; i++) {
            System.out.print("    ");
        }

        // second loop prints days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);

            // move line after saturday
            if ((first + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter month ");
        int month = sc.nextInt();

        System.out.print("enter year ");
        int year = sc.nextInt();

        // validation
        if (month < 1 || month > 12 || year < 1582) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        printCalendar(month, year);

        sc.close();
    }
}
