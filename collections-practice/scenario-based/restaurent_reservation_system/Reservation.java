
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private Table table;
    private Customer customer;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Reservation(Table table, Customer customer, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.table = table;
        this.customer = customer;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Table getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(Reservation other) {
        if (!this.date.equals(other.date)) return false;
        return (startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime));
    }

    public void displayDetails() {
        System.out.println("Reservation Details");
        System.out.println("Table: " + table.getTableNo());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Date: " + date);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("---------------------------");
    }
}
