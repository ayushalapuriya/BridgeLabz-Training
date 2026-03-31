package strategy;

public class StudentReservation implements ReservationStrategy {

    public void reserveBook(String bookName) {
        System.out.println("Student reserved '" + bookName + "' for 7 days.");
    }
}
