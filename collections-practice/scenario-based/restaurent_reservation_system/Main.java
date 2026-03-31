
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 2));
        system.addTable(new Table(3, 6));

        Customer alice = new Customer("Alice", "1234567890");
        Customer bob = new Customer("Bob", "0987654321");

        try {
            system.reserveTable(1, alice, LocalDate.of(2026, 1, 28), LocalTime.of(19, 0), LocalTime.of(21, 0));
            system.reserveTable(2, bob, LocalDate.of(2026, 1, 28), LocalTime.of(20, 0), LocalTime.of(22, 0));

            system.reserveTable(1, bob, LocalDate.of(2026, 1, 28), LocalTime.of(20, 0), LocalTime.of(22, 0));
        } catch (TableAlreadyReservedException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }

        system.showAvailableTables(LocalDate.of(2026, 1, 28), LocalTime.of(19, 0), LocalTime.of(20, 0));
    }
}
