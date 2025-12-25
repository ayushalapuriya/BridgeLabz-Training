import java.util.*;
public class CheckLeapYear {
	
	// Method to check leap year
	public static boolean checkLeapYear(int year) {
		if(year<1582) return false;
		if((year%4==0 && year%100!=0) || year%400==0) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter year: ");
		int year=sc.nextInt();
		
		boolean ans=checkLeapYear(year);
		
		// Display output
		if(ans) System.out.println("The given year is leap year.");
		else System.out.println("The given year is not leap year.");
		
		sc.close();
	}
}
