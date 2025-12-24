import java.util.*;
public class SmallestAndLargest {
	
	// Method to find smallest and largest among 3 numbers
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int[]ans=new int[2];
	
		// find smallest
		if(number1<number2 && number1<number3) ans[0]=1;
		else if(number2<number1 && number2<number3) ans[0]=2;
		else ans[0]=3;
		
		// find largest
		if(number1>number2 && number1>number3) ans[1]=1;
		else if(number2>number1 && number2>number3) ans[1]=2;
		else ans[1]=3;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter first number: ");
		int number1=sc.nextInt();
		System.out.println("Enter second number: ");
		int number2=sc.nextInt();
		System.out.println("Enter third number: ");
		int number3=sc.nextInt();
		
		int[]ans=findSmallestAndLargest(number1,number2,number3);
		
		// Display output
		System.out.println("The smallest number is number"+ans[0]+" and largest number is number"+ans[1]);
		sc.close();
	}
}
