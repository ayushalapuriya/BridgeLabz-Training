import java.util.Scanner;

public class MetroSmartCardFareDeduction {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Metro Smart Card System");
		int balance = 200;
		
		while (true) {
			System.out.println("Current Card Balance: "+balance+" Rs");
			System.out.println("Enter travel distance (km) or -1 to exit: ");
			int distance = sc.nextInt();

			if (distance < 0) {
				System.out.println("Exiting... Have a great day!");
				break;
			}
			
			int fare = (distance <= 5) ? 10 : (distance <= 15) ? 20 : 30;
			System.out.println("Fare Amount: "+fare+" Rs. Press 0 to proceed or any key to cancel: ");
			int consent = sc.nextInt();
			
			if (consent == 0) {
				if (balance >= fare) {
					balance = balance - fare;
					System.out.println("Payment Successful! Deducted: "+fare+" Rs");
				} else {
					System.out.println("Low Balance! Please recharge your card");
					break;
				}
			} else {
				System.out.println("Journey cancelled by user");
			}
		}

		System.out.println("Final Card Balance: "+balance+" Rs");
		sc.close();
	}
}
