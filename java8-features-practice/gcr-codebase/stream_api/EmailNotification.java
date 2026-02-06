import java.util.*;

public class EmailNotification {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@example.com", "b@example.com");
        emails.forEach(email -> System.out.println("Sending email to " + email));
    }
}
