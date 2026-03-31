import java.util.*;
public class FindFrequency3 {
	
	// Method to find frequency using nested loops
	public static String[] findFrequency(String str) {
		// Convert string to character array
		char[]chars=str.toCharArray();
		int[]freq=new int[chars.length];
		
		// Outer loop to iterate each character
		for(int i=0;i<chars.length;i++) {
			freq[i]=1;
			if(chars[i]=='0') continue;
			
			// Inner loop to check for duplicates
			for(int j=i+1;j<chars.length;j++) {
				if(chars[i]==chars[j]) {
					freq[i]++;
					chars[j]='0';  // Mark as counted
				}
			}
		}
		
		// Count non-zero characters
		int count=0;
		for(int i=0;i<chars.length;i++) {
			if(chars[i]!='0') {
				count++;
			}
		}
		
		// Store characters and frequencies in 1D array
		String[]result=new String[count];
		int idx=0;
		for(int i=0;i<chars.length;i++) {
			if(chars[i]!='0') {
				result[idx]=chars[i]+" - "+freq[i];
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
		String[]frequency=findFrequency(str);
		
		// Display result
		System.out.println("Character - Frequency");
		for(int i=0;i<frequency.length;i++) {
			System.out.println(frequency[i]);
		}
		
		sc.close();
	}
}