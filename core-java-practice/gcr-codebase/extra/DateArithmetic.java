import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take date input from the user
        System.out.print("Enter a date (YYYY-MM-DD): ");
        LocalDate inputDate=LocalDate.parse(sc.nextLine());

        // Add 7 days, 1 month, and 2 years
        LocalDate updatedDate=inputDate.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks from the updated date
        LocalDate finalDate=updatedDate.minusWeeks(3);

        // Display results
        System.out.println("Original Date: " + inputDate);
        System.out.println("Date after calculations: " + finalDate);

        sc.close();
    }
}

// LocalDate.parse(input) → converts the user input string into a LocalDate object.