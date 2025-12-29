import java.util.*;
public class BasicCalculator {
	
	// Addition
	public static double add(double a,double b) {
		return a+b;
	}
	
	// Subtraction
	public static double subtract(double a,double b) {
		return a-b;
	}
	
	// Multiplication
	public static double multiply(double a,double b) {
		return a*b;
	}
	
	// Division
	public static double divide(double a,double b) {
		if(b==0) {
			System.out.println("Error! Division by zero.");
			return 0;
		}
		return a/b;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Basic Calculator");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.print("Enter your choice: ");
		int choice=sc.nextInt();
		
		System.out.print("Enter first number: ");
		double num1=sc.nextDouble();
		System.out.print("Enter second number: ");
		double num2=sc.nextDouble();
		
		// Perform operation
		double result=0;
		if(choice==1) {
			result=add(num1,num2);
			System.out.println("Result: "+result);
		}
		else if(choice==2) {
			result=subtract(num1,num2);
			System.out.println("Result: "+result);
		}
		else if(choice==3) {
			result=multiply(num1,num2);
			System.out.println("Result: "+result);
		}
		else if(choice==4) {
			result=divide(num1,num2);
			if(num2!=0) System.out.println("Result: "+result);
		}
		else {
			System.out.println("Invalid choice!");
		}
		
		sc.close();
	}
}
