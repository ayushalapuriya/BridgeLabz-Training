import java.util.Scanner;

public class TextToLowerCase {
	
	// Text to Lowercase using user defined method
		public static String inLower(String text) {
			String result="";
			for(int i=0;i<text.length();i++) {
				int val=text.charAt(i);
				if(val>=65 && val<=90) {
					val=val+32;
					char ch=(char)val;
					result+=ch;
				}
				else result+=text.charAt(i);
			}
			return result;
		}
		
		// Compare both string 
		public static boolean compareStrings(String str1,String str2) {
			if(str1.equals(str2)) {
				return true;
			}
			return false;
		}
		
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			// Input text
			String text=sc.nextLine();
			
			// Convert text in upper case by both method
			String lowerCase1=inLower(text);
			String lowerCase2=text.toLowerCase();
			
			// Display result
			System.out.println("User-defined result: " + lowerCase1);
	        System.out.println("Pre defined result : " + lowerCase2);
	        System.out.println("Result from both methods are same: " +
	                compareStrings(lowerCase1, lowerCase2));
			sc.close();
		}
}
