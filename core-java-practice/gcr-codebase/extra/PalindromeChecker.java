import java.util.Scanner;
public class PalindromeChecker {
	
	// Method to take user input
	public static String takeInput(Scanner sc) {
		System.out.print("Enter a string: ");
		return sc.nextLine();
	}
	
	// Method to check string is palindrome or not
	public static boolean checkPali(String str) {
		String reverse="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse+=str.charAt(i);
		}
		if(str.equals(reverse)) return true;
		return false;
	}
	
	// Method to display output
	public static void display(boolean result) {
		if(result) System.out.println("Given string is palindrome and result is: "+result);
		else System.out.println("Given string is not palindrome and result is: "+result);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str=takeInput(sc);
		boolean result=checkPali(str);
		display(result);
		
		sc.close();
	}
}
