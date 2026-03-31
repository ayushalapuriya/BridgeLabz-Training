import java.util.*;
public class RemainderAndQuotientOfNum {
	
	// Method to find remainder and quotient of two numbers
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int[]ans=new int[2];
		
		// find remainder
		ans[0]=number%divisor;
		
		//find quotient
		ans[1]=number/divisor;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter a number: ");
		int number=sc.nextInt();
		System.out.println("Enter a divisor: ");
		int divisor=sc.nextInt();
		
		int[]ans=findRemainderAndQuotient(number,divisor);
		
		// Display output
		System.out.println("Remainder is: "+ans[0]+"\nQuotient is: "+ans[1]);
		sc.close();
	}
}
