package CommonBuiltinFunctions.dateTime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
  shows current time in different zones using zoneddatetime and zoneid
  also prints formatted time for india and new york
*/
public class TimeZonesZonedDateTime {
    public static void main(String[] args) {

        LocalTime t1 = LocalTime.now();
        System.out.println("local time now: " + t1);

        LocalDateTime dt1 = LocalDateTime.now();
        System.out.println("local date time now: " + dt1);

        ZonedDateTime z1 = ZonedDateTime.now();
        System.out.println("zoned date time: " + z1);

        ZonedDateTime india = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("zoned date time india: " + india);

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("zoned date time new york: " + ny);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
        System.out.println("formatted india time: " + india.format(fmt));
        System.out.println("formatted ny time: " + ny.format(fmt));
    }
}
