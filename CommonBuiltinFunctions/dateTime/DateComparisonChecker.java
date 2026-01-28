package CommonBuiltinFunctions.dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
  takes 2 dates from user (dd-MM-yyyy) and compares them
  prints before, after, or equal using isbefore/isafter/isequal
*/
public class DateComparisonChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            System.out.print("enter first date (dd-MM-yyyy): ");
            LocalDate d1 = LocalDate.parse(sc.nextLine().trim(), fmt);

            System.out.print("enter second date (dd-MM-yyyy): ");
            LocalDate d2 = LocalDate.parse(sc.nextLine().trim(), fmt);

            if (d1.isBefore(d2)) {
                System.out.println("first date is before second date");
            } else if (d1.isAfter(d2)) {
                System.out.println("first date is after second date");
            } else {
                System.out.println("both dates are equal");
            }

        } catch (DateTimeParseException e) {
            System.out.println("invalid date. use dd-MM-yyyy");
        } finally {
            sc.close();
        }
    }
}
