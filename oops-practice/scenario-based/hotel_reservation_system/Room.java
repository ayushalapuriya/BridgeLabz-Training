package hotel_reservation_system;

abstract class Room {
    protected int roomNumber;
    protected boolean available = true;
    protected double basePrice;

    Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    abstract String getRoomType();

    boolean isAvailable() {
        return available;
    }

    void bookRoom() {
        available = false;
    }

    void checkoutRoom() {
        available = true;
    }

    double getBasePrice() {
        return basePrice;
    }

    void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Base Price: " + basePrice);
        System.out.println("Available: " + available);
    }
}
