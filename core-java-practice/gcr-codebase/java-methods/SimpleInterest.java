import java.util.*;
public class SimpleInterest {
	
	// Find si
	public static double findSI(int p,int r,int t) {
		double si=(p*r*t)/100;
		return si;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter the principal: ");
		int principal=sc.nextInt();
		System.out.println("Enter the rate: ");
		int rate=sc.nextInt();
		System.out.println("Enter the time: ");
		int time=sc.nextInt();
		
		// Method to find simple interest
		double si=findSI(principal,rate,time);
		
		// Display Output
		System.out.println("The Simple Interest is "+si+" for Principal "+principal+" Rate of Interest "+rate+" and Time "+time);
		
		sc.close();
	}
}
