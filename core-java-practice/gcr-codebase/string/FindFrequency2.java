import java.util.*;
public class FindFrequency2 {
	
	// Method to find unique characters using nested loops
	public static char[] findUniqueChar(String str) {
		char[]temp=new char[str.length()];
		int idx=0;
		
		// Outer loop to pick each character
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			boolean isUnique=true;
			
			// Inner loop to check if already exists
			for(int j=0;j<i;j++) {
				if(ch==str.charAt(j)) {
					isUnique=false;
					break;
				}
			}
			
			if(isUnique) {
				temp[idx]=ch;
				idx++;
			}
		}
        
		// Create array with exact size
		char[]unique=new char[idx];
		for(int i=0;i<idx;i++) {
			unique[i]=temp[i];
		}
		return unique;
	}
	
	// Method to find frequency using unique characters
	public static String[][] findFrequency(String str) {
		// Array to store frequency using ASCII values
		int[]freq=new int[256];
		
		// Loop to count frequency of each character
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			freq[ch]++;
		}
		char[]uniqueChars=findUniqueChar(str);
		
		// Store characters and frequencies
		String[][]result=new String[uniqueChars.length][2];
		for(int i=0;i<uniqueChars.length;i++) {
			result[i][0]=String.valueOf(uniqueChars[i]);
			result[i][1]=String.valueOf(freq[uniqueChars[i]]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		// Find frequency of characters
		String[][]frequency=findFrequency(str);
		
		// Display result
		System.out.println("Character\tFrequency");
		for(int i=0;i<frequency.length;i++) {
			System.out.println(frequency[i][0]+"\t\t"+frequency[i][1]);
		}
		
		sc.close();
	}
}