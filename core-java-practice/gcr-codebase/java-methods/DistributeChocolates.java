import java.util.Scanner;
public class DistributeChocolates {
	
	// Method to find remainder and quotient of two numbers
	public static int[] findRemainderAndQuotient(int N, int M) {
		int[]ans=new int[2];
		
		// find remainder
		ans[0]=N%M;
		
		//find quotient
		ans[1]=N/M;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter number of choclates: ");
		int number=sc.nextInt();
		System.out.println("Enter number of childrens: ");
		int divisor=sc.nextInt();
		
		int[]ans=findRemainderAndQuotient(number,divisor);
		
		// Display output
		System.out.println("The number of chocolates each child gets: "+ans[1]+"\nNumber of remaining chololates are: "+ans[0]);
		sc.close();
	}
}
