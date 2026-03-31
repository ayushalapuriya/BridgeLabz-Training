package hotel_reservation_system;

public class DeluxeRoom extends Room {

    DeluxeRoom(int roomNumber) {
        super(roomNumber, 4000);
    }

    @Override
    String getRoomType() {
        return "Deluxe Room";
    }
}
