package users;

import observer.User;
import strategy.ReservationStrategy;

public class Faculty implements User {

    private String name;
    private ReservationStrategy reservationStrategy;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public void showRole() {
        System.out.println(name + " is a Faculty.");
    }

    @Override
    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }

    @Override
    public void setReservationStrategy(ReservationStrategy strategy) {
        this.reservationStrategy = strategy;
    }

    @Override
    public void reserve(String bookName) {
        if (reservationStrategy == null) {
            System.out.println("Reservation strategy not set for Faculty.");
            return;
        }
        reservationStrategy.reserveBook(bookName);
    }
}
