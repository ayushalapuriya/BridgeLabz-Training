import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;
    Doctor(String n, String s, boolean a) { name = n; specialty = s; availableOnWeekend = a; }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Alice", "Cardiology", true),
            new Doctor("Bob", "Neurology", false),
            new Doctor("Charlie", "Dermatology", true)
        );

        doctors.stream()
               .filter(d -> d.availableOnWeekend)
               .sorted(Comparator.comparing(d -> d.specialty))
               .forEach(d -> System.out.println(d.name + " - " + d.specialty));
    }
}
