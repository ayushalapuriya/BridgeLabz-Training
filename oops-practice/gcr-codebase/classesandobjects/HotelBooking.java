
public class HotelBooking {
	
	// Attributes
	String guestName;
	String roomType;
	int nights;
	
	// Default constructor
	HotelBooking(){
		this.guestName="Guest";
		this.roomType="Standard";
		this.nights=1;
	}
	
	// Parameterized constructor
	HotelBooking(String guestName,String roomType,int nights){
		this.guestName=guestName;
		this.roomType=roomType;
		this.nights=nights;
	}
	
	// Copy constructor
	HotelBooking(HotelBooking other){
		this.guestName=other.guestName;
		this.roomType=other.roomType;
		this.nights=other.nights;
	}
	
	// Method to display booking details
	void display(){
		System.out.println("Guest Name: "+guestName);
		System.out.println("Room Type: "+roomType);
		System.out.println("Nights: "+nights);
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) {
		HotelBooking booking1=new HotelBooking();
		HotelBooking booking2=new HotelBooking("Kumar","Deluxe",3);
		HotelBooking booking3=new HotelBooking(booking2);
		
		System.out.println("Default Booking:");
		booking1.display();
		
		System.out.println("Parameterized Booking:");
		booking2.display();
		
		System.out.println("Copied Booking:");
		booking3.display();
	}
}
