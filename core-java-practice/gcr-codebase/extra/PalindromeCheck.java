import java.util.*;
public class PalindromeCheck {
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
		if(reverse.equals(str)) System.out.println("The given string is palindrome.");
		else System.out.println("The given string is not palindrome.");
		
		sc.close();
	}
}
