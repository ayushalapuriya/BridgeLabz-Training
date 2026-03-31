import java.util.Scanner;
public class Anagram1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter first string: ");
		String str1=sc.next();
		System.out.print("Enter second string: ");
		String str2=sc.next();
		
		// Find frequency of both string
		int[]freq1=new int[256];
		for(char c:str1.toCharArray()) freq1[c]++;
		int[]freq2=new int[256];
		for(char c:str2.toCharArray()) freq2[c]++;
		
		// Check given two strings are anagram or not
		for(int i=0;i<256;i++) {
			if(freq1[i]!=freq2[i]) {
				System.out.println("Given strings are not anagram.");
				return;
			}
		}
		System.out.println("Given strings are anagram.");
		
		sc.close();
	}
}
