import java.util.*;
public class Anagram {
	
	// Method to check if two texts are anagrams
	public static boolean checkAnagram(String str1,String str2) {
		// Check if lengths are equal
		if(str1.length()!=str2.length()) {
			return false;
		}
		
		// Create arrays to store frequency of characters
		int[]freq1=new int[256];
		int[]freq2=new int[256];
		
		// Find frequency of characters in first text
		for(int i=0;i<str1.length();i++) {
			char ch=str1.charAt(i);
			freq1[ch]++;
		}
		
		// Find frequency of characters in second text
		for(int i=0;i<str2.length();i++) {
			char ch=str2.charAt(i);
			freq2[ch]++;
		}
		
		// Compare frequencies of both texts
		for(int i=0;i<256;i++) {
			if(freq1[i]!=freq2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input two strings
		System.out.print("Enter first string: ");
		String str1=sc.next();
		System.out.print("Enter second string: ");
		String str2=sc.next();
		
		// Check if anagrams
		boolean result=checkAnagram(str1,str2);
		
		// Display result
		if(result) System.out.println("The strings are anagrams");
		else System.out.println("The strings are not anagrams");
		sc.close();
	}
}