
public class MovieTicket {
	
	// Attributes
	String movieName;
	String seatNumber;
	double price;
	boolean isBooked;
	
	// Constructor
	MovieTicket(){
		this.isBooked=false;
	}
	
	// Method to book ticket
	void bookTicket(String movieName,String seatNumber,double price){
		if(!isBooked){
			this.movieName=movieName;
			this.seatNumber=seatNumber;
			this.price=price;
			this.isBooked=true;
			System.out.println("Ticket booked for movie: "+movieName);
			System.out.println("Seat Number: "+seatNumber);
		}
        else{
			System.out.println("House full!!! sorry..... Ticket already booked");
		}
	}
	
	// Method to display ticket details
	void displayTicket(){
		if(isBooked){
			System.out.println("Ticket booked for movie: "+movieName);
			System.out.println("Seat Number: "+seatNumber);
			System.out.println("Price: $"+price);
		}else{
			System.out.println("Ticket have not booked yet....");
		}
	}
	
	public static void main(String[] args) {
		MovieTicket ticket=new MovieTicket();
		
		ticket.displayTicket();
		ticket.bookTicket("Dragon","A10",120.0);
		ticket.bookTicket("Dragon","B5",120.0);
		ticket.bookTicket("Dragon","C3",120.0);
		System.out.println("Price: $"+ticket.price);
		System.out.println();
		ticket.displayTicket();
	}
}