import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatting {
    public static void main(String[] args) {

        // Get the current date
        LocalDate today=LocalDate.now();

        // Define different date formats
        DateTimeFormatter format1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3=DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display the current date in different formats
        System.out.println("Date in dd/MM/yyyy format: "+today.format(format1));
        System.out.println("Date in yyyy-MM-dd format: "+today.format(format2));
        System.out.println("Date in EEE, MMM dd, yyyy format: "+today.format(format3));
    }
}

/*
 LocalDate.now() → gets the current date.

DateTimeFormatter.ofPattern("pattern") → defines how the date should appear.

"dd/MM/yyyy" → day/month/year

"yyyy-MM-dd" → year-month-day

"EEE, MMM dd, yyyy" → abbreviated day, month name, day, year (e.g., Mon, Dec 28, 2025)

today.format(formatter) → converts the date into the chosen format.
 */