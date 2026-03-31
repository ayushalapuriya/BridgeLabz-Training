import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class DiffTimeZones {
    public static void main(String[] args) {

        // Formatter for readable output
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        // GMT
        ZonedDateTime gmtTime=ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("GMT Time: "+gmtTime.format(formatter));

        // IST (Indian Standard Time)
        ZonedDateTime istTime=ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("IST Time: "+istTime.format(formatter));

        // PST (Pacific Standard Time)
        ZonedDateTime pstTime=ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("PST Time: "+pstTime.format(formatter));
    }
}

/*
This Java program displays the current date and time in three different time zones: GMT, IST, and PST.

The program imports classes from the java.time package to work with date, time, and time zones.

A DateTimeFormatter is created to format the date and time in a readable form (day-month-year hours:minutes:seconds along with the time zone).

ZonedDateTime.now() is used along with ZoneId.of() to get the current time for each specific time zone.
 */