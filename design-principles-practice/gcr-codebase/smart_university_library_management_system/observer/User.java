package observer;

import strategy.ReservationStrategy;

public interface User extends Observer {
    void showRole();
    void setReservationStrategy(ReservationStrategy strategy);
    void reserve(String bookName);
}
