
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ReservationSystem {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addTable(Table table) {
        tables.put(table.getTableNo(), table);
    }

    public void reserveTable(int tableNumber, Customer customer, LocalDate date, LocalTime start, LocalTime end) throws TableAlreadyReservedException {
        Table table = tables.get(tableNumber);
        if (table == null) {
            System.out.println("Table " + tableNumber + " does not exist.");
            System.out.println();
            return;
        }

        Reservation newRes = new Reservation(table, customer, date, start, end);

        for (Reservation r : reservations) {
            if (r.getTable().getTableNo() == tableNumber && r.overlaps(newRes)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved for this time.");
            }
        }

        reservations.add(newRes);
        System.out.println("Reservation successful!");
        newRes.displayDetails();
    }

    public void cancelReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            System.out.println("Reservation cancelled: " + reservation);
        } else {
            System.out.println("Reservation not found.");
        }
        reservation.displayDetails();
    }

    public void showAvailableTables(LocalDate date, LocalTime start, LocalTime end) {
        System.out.println("Available tables on " + date + " from " + start + " to " + end + ":");
        for (Table table : tables.values()) {
            boolean available = true;
            for (Reservation r : reservations) {
                if (r.getTable().getTableNo() == table.getTableNo() && r.overlaps(new Reservation(table, null, date, start, end))) {
                    available = false;
                    break;
                }
            }
            if (available) {
                table.displayTable();
            }
            System.out.println();
        }
    }
}
