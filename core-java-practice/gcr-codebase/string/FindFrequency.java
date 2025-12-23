import java.util.*;
public class FindFrequency {
	
	// Method to find frequency of characters
	public static String[][] findFrequency(String str) {
		// Array to store frequency using ASCII values
		int[]freq=new int[256];
		
		// Loop to count frequency of each character
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			freq[ch]++;
		}
		
		// Count total unique characters
		int count=0;
		for(int i=0;i<256;i++) {
			if(freq[i]>0) {
				count++;
			}
		}
		
		// Store characters and their frequencies in 2D array
		String[][]result=new String[count][2];
		int idx=0;
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(freq[ch]>0) {
				result[idx][0]=String.valueOf(ch);
				result[idx][1]=String.valueOf(freq[ch]);
				freq[ch]=0;  // Mark as added
				idx++;
			}
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