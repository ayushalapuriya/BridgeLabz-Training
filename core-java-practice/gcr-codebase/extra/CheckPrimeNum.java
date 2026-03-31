import java.util.Scanner;
public class CheckPrimeNum {
	
	// Method to check number is prime or not
	public static boolean checkPrime(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	// Method to display result
	public static void display(boolean prime,int num) {
		if(prime) System.out.println("Yes, the given number "+num+" is primme.");
		else System.out.println("No, the given number "+num+" is not prime.");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a number: ");
		int num=sc.nextInt();
		
		boolean prime=checkPrime(num);
		display(prime,num);
		
		sc.close();
	}
}
