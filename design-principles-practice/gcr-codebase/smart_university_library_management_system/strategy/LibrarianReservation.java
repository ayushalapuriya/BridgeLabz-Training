package strategy;

public class LibrarianReservation implements ReservationStrategy {

    public void reserveBook(String bookName) {
        System.out.println("Librarian has immediate access to '" + bookName + "'.");
    }
}
