import java.util.*;
public class RemoveDuplicatesFromString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.next();
		
		// Remove duplicates
		String unique="";
		int[]freq=new int[256];
		for(char c:str.toCharArray()) {
			if(freq[c]==0) unique+=c;
			freq[c]++;
		}
		
		// Display output
		System.out.println("After removing duplicates final string is: "+unique);
		sc.close();
	}
}
