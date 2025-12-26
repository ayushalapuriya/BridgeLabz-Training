import java.util.*;
public class LongestWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.nextLine();
		
		// Find longest word after checking length
		String[]words=str.split(" ");
		int len=0;
		String longest="";
		for(String s:words) {
			if(s.length()>len) {
				len=s.length();
				longest=s;
			}
		}
		
		// Display output
		System.out.println("The longest word in sentance is: "+longest);
		
		sc.close();
	}
}
