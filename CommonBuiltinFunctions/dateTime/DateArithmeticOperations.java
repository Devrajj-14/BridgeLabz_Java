package CommonBuiltinFunctions.dateTime;

import java.time.LocalDate;

/*
  takes current date and performs date arithmetic
  +7 days, +1 month, +2 years then -3 weeks
*/
public class DateArithmeticOperations {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalDate afterAdd = today.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("after adding 7 days, 1 month, 2 years: " + afterAdd);

        LocalDate afterSub = afterAdd.minusWeeks(3);
        System.out.println("after subtracting 3 weeks: " + afterSub);
    }
}
