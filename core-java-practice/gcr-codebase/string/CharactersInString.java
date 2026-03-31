import java.util.*;
public class CharactersInString {
	
	// Find characters by user defined
	public static char[] findCharacters(String str) {
		char[]characters=new char[str.length()];
		for(int i=0;i<str.length();i++) characters[i]=str.charAt(i);
		return characters;
	}
	
	// Compare both character array
	public static boolean isEqual(char[]arr1,char[]arr2) {
		if(arr1.length!=arr2.length) return false;
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		// Find character by both method
		char[]charArray1=findCharacters(str); // user defined
		char[]charArray2=str.toCharArray(); // predefined
		
		// Display result
		System.out.println("After comparing both array the result is: "+isEqual(charArray1,charArray2));
		sc.close();
	}
}
