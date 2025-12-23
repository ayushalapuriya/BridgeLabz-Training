import java.util.*;
public class Palindrome {
	
	// Logic 1: Check palindrome using loop
	public static boolean checkPalindromeLoop(String str) {
		int start=0;
		int end=str.length()-1;
		
		// Loop to compare characters from start and end
		while(start<end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	// Logic 2: Check palindrome using recursion
	public static boolean checkPalindromeRecursion(String str,int start,int end) {
		// Base case
		if(start>=end) return true;
		
		// Check if characters are equal
		if(str.charAt(start)!=str.charAt(end)) return false;
		
		// Recursive call
		return checkPalindromeRecursion(str,start+1,end-1);
	}
	
	// Method to reverse string using charAt method
	public static char[] reverseString(String str) {
		char[]reverse=new char[str.length()];
		int idx=0;
		
		for(int i=str.length()-1;i>=0;i--) {
			reverse[idx]=str.charAt(i);
			idx++;
		}
		return reverse;
	}
	
	// Logic 3: Check palindrome using character arrays
	public static boolean checkPalindromeArray(String str) {
		// Create character array
		char[]original=str.toCharArray();
		char[]reverse=reverseString(str);
		
		// Compare original and reverse arrays
		for(int i=0;i<original.length;i++) if(original[i]!=reverse[i]) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		// Check palindrome using three methods
		boolean result1=checkPalindromeLoop(str);
		boolean result2=checkPalindromeRecursion(str,0,str.length()-1);
		boolean result3=checkPalindromeArray(str);
		
		// Display result
		System.out.println("Palindrome check using loop: "+result1);
		System.out.println("Palindrome check using recursion: "+result2);
		System.out.println("Palindrome check using array: "+result3);
		
		sc.close();
	}
}