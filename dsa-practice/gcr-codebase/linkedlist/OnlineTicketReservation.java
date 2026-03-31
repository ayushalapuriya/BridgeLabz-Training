// Node representing a booked ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class OnlineTicketReservation {
    private TicketNode last = null;

    // Add New Ticket at End
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (last == null) {  // Empty list
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        System.out.println("Ticket booked successfully for " + customerName);
    }

    // Remove Ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove");
            return;
        }

        TicketNode current = last.next;
        TicketNode prev = last;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed successfully");
                break;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("Ticket not found");
        }
    }

    // Display All Tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked");
            return;
        }

        System.out.println("Current Tickets:");
        TicketNode temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                               ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName +
                               ", Seat: " + temp.seatNumber +
                               ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    // Search Ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (last == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId +
                                   ", Customer: " + temp.customerName +
                                   ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber +
                                   ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);

        if (!found) {
            System.out.println("No tickets found for: " + keyword);
        }
    }

    // Count Total Tickets
    public void countTickets() {
        if (last == null) {
            System.out.println("Total Tickets Booked: 0");
            return;
        }

        int count = 0;
        TicketNode temp = last.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);

        System.out.println("Total Tickets Booked: " + count);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        OnlineTicketReservation system = new OnlineTicketReservation();

        system.addTicket(101, "Alice", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Avengers", "A2", "10:05 AM");
        system.addTicket(103, "Charlie", "Spiderman", "B1", "11:00 AM");

        System.out.println();
        system.displayTickets();

        System.out.println();
        system.searchTicket("Avengers");

        System.out.println();
        system.countTickets();

        System.out.println();
        system.removeTicket(102);

        System.out.println();
        system.displayTickets();
    }
}
