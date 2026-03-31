import java.util.*;
public class SumOfNaturalNum1 {
	
	// Method to find sum of n natural number recursively
	public static long findSum(int n) {
		if(n<1) return 0;
		return n+findSum(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter a natural number: ");
		int num=sc.nextInt();
		
		long sum=findSum(num); // by recursive
		long sum1=(num*(num+1))/2; // by formula
		
		// Compare result and display
		if(sum==sum1) System.out.println("Sum by both methods are same and sum is: "+sum);
		else System.out.println("Sum by both methods are different, by recursive is: "+sum+" and by formula is: "+sum1);
		
		sc.close();
	}
}
