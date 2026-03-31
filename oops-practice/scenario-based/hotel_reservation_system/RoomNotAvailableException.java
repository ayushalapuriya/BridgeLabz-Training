package hotel_reservation_system;

public class RoomNotAvailableException extends Exception {
    RoomNotAvailableException(String message) {
        super(message);
    }
}
