import java.util.Scanner;
public class MaximumAmongThree {
	
	// Method to find maximum number among three
	public static int findMax(int a,int b,int c) {
		int max=a;
		if(b>max) max=b;
		if(c>max) max=c;
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter first number: ");
		int num1=sc.nextInt();
		System.out.print("Enter second number: ");
		int num2=sc.nextInt();
		System.out.print("Enter third number: ");
		int num3=sc.nextInt();
		
		int maxNum=findMax(num1,num2,num3);
		
		// Display output
		System.out.println("Maximum number is: "+maxNum);
		sc.close();
	}
}
