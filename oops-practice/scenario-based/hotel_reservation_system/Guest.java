package hotel_reservation_system;

public class Guest {
    private int guestId;
    private String name;
    private String phone;

    Guest(int guestId, String name, String phone) {
        this.guestId = guestId;
        this.name = name;
        this.phone = phone;
    }

    void displayGuestDetails() {
        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }
}
