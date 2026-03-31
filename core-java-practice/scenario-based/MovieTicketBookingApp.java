import java.util.Scanner;
public class MovieTicketBookingApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter number of customers: ");
		int totalCustomers=sc.nextInt();
		// Loop through multiple customers
		for(int i=1;i<=totalCustomers;i++) {
			System.out.println("\nCustomer "+i);
			System.out.print("Enter movie type (Action/Comedy/Drama): ");
			String movieType=sc.next();
			String selectedMovie="";
			// Use switch for movie type
			switch(movieType) {
			case "Action":
				selectedMovie="Action Movie";
				break;
			case "Comedy":
				selectedMovie="Comedy Movie";
				break;
			case "Drama":
				selectedMovie="Drama Movie";
				break;
			}
			
			System.out.print("Enter seat type (gold/silver): ");
			String seatType=sc.next();
			System.out.print("Want snacks? (yes/no): ");
			String wantSnacks=sc.next();
			String snacksStatus="";
			// Use if for snacks
			if(wantSnacks.equalsIgnoreCase("yes")) snacksStatus="With Snacks";
			else snacksStatus="No Snacks";
			System.out.println("\nBooking Confirmed:");
			System.out.println("Movie: "+selectedMovie);
			System.out.println("Seat: "+seatType);
			System.out.println("Snacks: "+snacksStatus);
		}
		
		sc.close();
	}
}
