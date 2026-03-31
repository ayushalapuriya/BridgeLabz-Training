import java.util.*;
public class LeadingTrailingSpaces {
	
	// Method to trim leading and trailing spaces
	public static int[] trimSpaces(String text) {
		int startIndex=0;
		int endIndex=text.length()-1;
		
		// Find starting point with no leading spaces
		while(startIndex<=endIndex && text.charAt(startIndex)==' ') {
			startIndex++;
		}
		
		// Find ending point with no trailing spaces
		while(endIndex>=startIndex && text.charAt(endIndex)==' ') {
			endIndex--;
		}
		
		// Return start and end index in array
		int[] indices=new int[2];
		indices[0]=startIndex;
		indices[1]=endIndex+1;
		return indices;
	}
	
	// Method to create substring using charAt method
	public static String createSubstring(String text,int start,int end) {
		String result="";
		for(int i=start;i<end;i++) {
			result+=text.charAt(i);
		}
		return result;
	}
	
	// Method to compare two strings using charAt method
	public static boolean compareStrings(String str1,String str2) {
		if(str1.length()!=str2.length()) return false;
		
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string with spaces
		System.out.print("Enter a string with spaces: ");
		String input=sc.nextLine();		
		int[] trimIndices=trimSpaces(input);
		
		// Create trimmed string using user defined substring method
		String userTrimmed=createSubstring(input,trimIndices[0],trimIndices[1]);
		String predefinedTrimmed=input.trim();
		
		// Compare both results
		boolean isMatch=compareStrings(userTrimmed,predefinedTrimmed);
		
		// Display result
		System.out.println("Original string: '"+input+"'");
		System.out.println("Trimmed by user defined method: '"+userTrimmed+"'");
		System.out.println("Trimmed by predefined method: '"+predefinedTrimmed+"'");
		System.out.println("Both methods match: "+isMatch);
		
		sc.close();
	}
}