package hotel_reservation_system;

public class Reservation {
    private Guest guest;
    private Room room;
    private int stayDays;
    private double totalBill;

    Reservation(Guest guest, Room room, int stayDays, PricingStrategy pricing) {
        this.guest = guest;
        this.room = room;
        this.stayDays = stayDays;
        this.totalBill = pricing.calculatePrice(room.getBasePrice(), stayDays);
        room.bookRoom();
    }

    void generateInvoice() {
        System.out.println("-------- INVOICE --------");
        guest.displayGuestDetails();
        room.displayRoomDetails();
        System.out.println("Stay Days: " + stayDays);
        System.out.println("Total Bill: " + totalBill);
        System.out.println("-------------------------");
    }

    void checkout() {
        room.checkoutRoom();
        System.out.println("Checkout successful for Room " + room.roomNumber);
    }
}
