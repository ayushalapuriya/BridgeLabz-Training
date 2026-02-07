package users;
import observer.User;
import strategy.ReservationStrategy;

public class Student implements User {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void showRole() {
        System.out.println(name + " is a Student.");
    }

    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }
    
    private ReservationStrategy strategy;

    public void setReservationStrategy(ReservationStrategy strategy) {
        this.strategy = strategy;
    }

    public void reserve(String bookName) {
        strategy.reserveBook(bookName);
    }

}