import java.util.Scanner;
public class RohanLibraryReminderApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int totalFine=0;
		// User input
		for(int i=1;i<=5;i++) {
			System.out.println("\nBook "+i);
			System.out.print("Enter due date (dd-mm-yyyy): ");
			String dueDate=sc.next();
			System.out.print("Enter return date (dd-mm-yyyy): ");
			String returnDate=sc.next();
			
			// Parse dates to calculate difference
			String[] dueParts=dueDate.split("-");
			String[] returnParts=returnDate.split("-");
			
			int dueDay=Integer.parseInt(dueParts[0]);
			int returnDay=Integer.parseInt(returnParts[0]);
			
			if(returnDay>dueDay) {
				int lateDays=returnDay-dueDay;
				int fine=lateDays*5;
				totalFine+=fine;
				System.out.println("Late by "+lateDays+" days. Fine: "+fine+" Rs");
			}
            else System.out.println("Returned on time. No fine.");
		}
		System.out.println("\nTotal Fine: "+totalFine+" Rs");
		sc.close();
	}
}
