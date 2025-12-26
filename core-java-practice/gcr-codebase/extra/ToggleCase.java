import java.util.*;
public class ToggleCase {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.next();
		
		// Convert uppercase characters to lowercase and vice versa
		String result="";
		for(char c:str.toCharArray()) {
			if(c>='A' && c<='Z') result+=(char)(c+32);
			else result+=(char)(c-32);
		}
		
		// Display output
		System.out.println("After performing toggle case, result string is: "+result);
		sc.close();
	}
}
