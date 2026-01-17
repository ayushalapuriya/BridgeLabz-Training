import java.util.Scanner;

public class ReverseString {
	
	public static String reverseStr(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.next();
		
		String ans = reverseStr(s);
		System.out.println("Reverse string is: " + ans);
		
		sc.close();
	}
}
