import java.util.*;
public class NoIsPositiveNegativeZero {
	
	// Method to check the number is positive, negative or zero
	public static int checkNum(int num) {
		if(num<0) return -1;
		else if(num>0) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User Input
		System.out.println("Enter a number: ");
		int num=sc.nextInt();
		
		int ans=checkNum(num);
		
		// Display output
		System.out.println("Result is: "+ans);
		sc.close();
	}
}
