import java.util.*;
import java.util.function.Predicate;

class Alert {
    String message;
    String type;
    int priority;

    Alert(String message, String type, int priority) {
        this.message = message;
        this.type = type;
        this.priority = priority;
    }

    public String toString() {
        return message + " , " + " Type:" + type + " , " + " Priority:" + priority;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("Heart rate high", "CRITICAL", 1));
        alerts.add(new Alert("Medication reminder", "INFO", 3));
        alerts.add(new Alert("Appointment scheduled", "INFO", 4));
        alerts.add(new Alert("Blood pressure low", "CRITICAL", 1));

        Predicate<Alert> criticalOnly = a -> a.type.equals("CRITICAL");
        Predicate<Alert> highPriorityOnly = a -> a.priority <= 2;

        alerts.stream()
              .filter(criticalOnly)
              .forEach(System.out::println);

        System.out.println();

        alerts.stream()
              .filter(highPriorityOnly)
              .forEach(System.out::println);
    }
}
