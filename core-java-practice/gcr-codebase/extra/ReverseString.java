import java.util.*;
public class ReverseString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.next();
		
		// Find reverse string
		String reverse="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse+=str.charAt(i);
		}
		
		// Display output
		System.out.println("The reverse string is: "+reverse);
		
		sc.close();
	}
}
