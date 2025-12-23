import java.util.*;
public class FirstNonRepeatChar {
	
	// Method to find first non-repeating character
	public static char findFirstNonRepeating(String str) {
		int[]frequency=new int[256];		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			frequency[ch]++;
		}
		
		// Loop to find first non-repeating character
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(frequency[ch]==1) return ch;
		}
		return ' ';
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		char result=findFirstNonRepeating(str);
		
		// Display result
		if(result==' ') System.out.println("No non-repeating character found");
		else System.out.println("First non-repeating character is: "+result);
		sc.close();
	}
}
