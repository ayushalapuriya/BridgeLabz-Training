import java.util.*;
public class SubstringOccurences {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.nextLine();
		System.out.print("Enter a substring: ");
		String subStr=sc.next();
		
		// FInd occurence of substring
		int count=0;
		int len=subStr.length();
		for(int i=0;i<str.length()-len+1;i++) {
			if(str.substring(i,i+len).equals(subStr)) count++;
		}
		
		// Display output
		System.out.println("The total occurence of given substring in string are: "+count);
		
		sc.close();
	}
}
