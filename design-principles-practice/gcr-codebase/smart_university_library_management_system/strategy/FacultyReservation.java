package strategy;

public class FacultyReservation implements ReservationStrategy {

    public void reserveBook(String bookName) {
        System.out.println("Faculty reserved '" + bookName + "' for 30 days.");
    }
}
