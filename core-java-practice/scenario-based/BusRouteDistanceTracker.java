import java.util.Scanner;
public class BusRouteDistanceTracker {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter distance between stops: ");
		int stopDist=sc.nextInt();
		
		// Calculate distance
		boolean flag=true;
		int totalDistance=0;
		while(flag) {
			totalDistance+=stopDist;
			System.out.print("If u want to get off at a stop, enter yes or no: ");
			String choose=sc.next();
			if(choose.equalsIgnoreCase("yes")) flag=false;
		}
		
		// Display output
		System.out.println("Total distance travelled by you is: "+totalDistance);
		
		sc.close();
	}
}
