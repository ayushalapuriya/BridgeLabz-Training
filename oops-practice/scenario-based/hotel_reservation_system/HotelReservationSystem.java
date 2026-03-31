package hotel_reservation_system;

public class HotelReservationSystem {

    public static void main(String[] args) {

        try {
            Guest guest = new Guest(1, "Ayush", "9876543210");

            Room standardRoom = new StandardRoom(101);
            Room deluxeRoom = new DeluxeRoom(201);

            PricingStrategy normalPricing = new NormalPricing();
            PricingStrategy seasonalPricing = new SeasonalPricing();

            if (!standardRoom.isAvailable()) {
                throw new RoomNotAvailableException("Standard Room not available");
            }

            Reservation r1 =
                    new Reservation(guest, standardRoom, 3, normalPricing);
            r1.generateInvoice();
            r1.checkout();

            System.out.println();

            if (!deluxeRoom.isAvailable()) {
                throw new RoomNotAvailableException("Deluxe Room not available");
            }

            Reservation r2 =
                    new Reservation(guest, deluxeRoom, 2, seasonalPricing);
            r2.generateInvoice();
            r2.checkout();

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
