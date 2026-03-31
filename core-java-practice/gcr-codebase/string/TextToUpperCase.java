import java.util.*;
public class TextToUpperCase {
	
	// Text to Uppercase using user defined method
	public static String inUpper(String text) {
		String result="";
		for(int i=0;i<text.length();i++) {
			int val=text.charAt(i);
			if(val>=97 && val<=122) {
				val=val-32;
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
		String upperCase1=inUpper(text);
		String upperCase2=text.toUpperCase();
		
		// Display result
		System.out.println("User-defined result: " + upperCase1);
        System.out.println("Pre defined result : " + upperCase2);
        System.out.println("Result from both methods are same: " +
                compareStrings(upperCase1, upperCase2));
		sc.close();
	}
}
