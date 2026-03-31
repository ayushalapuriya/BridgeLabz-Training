import java.util.Scanner;
public class LCMAndGCD {
	
	// Method to take input
	public static int[] takeInput(Scanner sc) {
		System.out.print("Enter first number: ");
		int a=sc.nextInt();
		System.out.print("Enter second number: ");
		int b=sc.nextInt();
		return new int[] {a,b};
	}
	
	// Method to find GCD of two numbers
	public static int findGCD(int a,int b) {
		while(b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
	}
	
	// Method to find LCM of two numbers
	public static int findLCM(int a,int b, int gcd) {
		int lcm=(a*b)/gcd;
		return lcm;
	}
	
	// Display output
	public static void display(int a,int b,int gcd, int lcm) {
		System.out.println("LCM of "+a+" and "+b+" is: "+lcm);
		System.out.println("GCD of "+a+" and "+b+" is: "+gcd);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[]num=takeInput(sc);
		int gcd=findGCD(num[0],num[1]);
		int lcm=findLCM(num[0],num[1],gcd);
		display(num[0],num[1],gcd,lcm);
		sc.close();
	}
}
