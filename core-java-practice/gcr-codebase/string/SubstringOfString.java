import java.util.*;
public class SubstringOfString {
	
	// Find substring by user defined method
	public static String findSubstring(String str,int st,int end) {
		String result="";
		for(int i=st;i<end;i++) result+=str.charAt(i);
		return result;
	}
	
	// Compare both result
	public static boolean isEqual(String str1,String str2) {
		if(str1.length()!=str2.length()) return false;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string, starting and ending index
		String str=sc.next();
		int start=sc.nextInt();
		int end=sc.nextInt();
		
		// substring by both method
		String str1=findSubstring(str,start,end); // user defined
		String str2=str.substring(start,end); // predefined
		
		System.out.println("Result after comparing substring by both method is: "+isEqual(str1,str2));
		sc.close();
	}
}
