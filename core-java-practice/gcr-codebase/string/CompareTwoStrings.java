import java.util.*;
public class CompareTwoStrings {
	
	// Compare string using charAt()
	public static boolean isEqual(String str1,String str2) {
		if(str1.length()!=str2.length()) return false;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input 2 strings
		String str1=sc.next();
		String str2=sc.next();
		
		// Display result
		if(isEqual(str1,str2)==str1.equals(str2)) System.out.println("The result is same from both methods and result is: "+isEqual(str1,str2));
		else System.out.println("The result from user defined method is: "+isEqual(str1,str2)+" and result from in built method is: "+str1.equals(str2));
		sc.close();
	}
}
