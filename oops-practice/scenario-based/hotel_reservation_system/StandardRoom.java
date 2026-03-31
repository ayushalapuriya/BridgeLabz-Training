package hotel_reservation_system;

public class StandardRoom extends Room {

    StandardRoom(int roomNumber) {
        super(roomNumber, 2000);
    }

    @Override
    String getRoomType() {
        return "Standard Room";
    }
}
