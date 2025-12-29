import java.util.Scanner;
public class FactorialUsingRecursion {
	
	// Method to take user input
	public static int takeInput(Scanner sc) {
		System.out.print("Enter a number: ");
		return sc.nextInt();
	}
	
	// Method to calculate factorial using recursion
	public static long factorial(int num) {
		if(num<=1) return 1;
		return num*factorial(num-1);
	}
	
	// Display output
	public static void display(long ans,int num) {
		System.out.println("Factorial of "+num+" is: "+ans);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num=takeInput(sc);
		long ans=factorial(num);
		display(ans,num);
		
		sc.close();
	}
}
