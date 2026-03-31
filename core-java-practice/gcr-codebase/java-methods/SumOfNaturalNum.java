import java.util.*;
public class SumOfNaturalNum {
	
	// Method to find sum of n natural number
	public static long findSum(int num) {
		long sum=0;
		for(int i=1;i<=num;i++) sum+=i;
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a positive number: ");
		int num=sc.nextInt();
		
		// Display output
		if(num<0) System.out.println("Invalid natural number");
		else System.out.println("The sum of n natural number is: "+findSum(num));
		sc.close();
	}
}
