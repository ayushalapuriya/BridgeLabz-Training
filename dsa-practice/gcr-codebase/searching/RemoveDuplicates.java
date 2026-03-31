import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {
	
	public static String removeDuplicate(String s) {
		StringBuilder sb = new StringBuilder();
		HashSet<Character> hs = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(hs.contains(c)) continue;
			else {
				sb.append(c);
				hs.add(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.next();
		
		String ans = removeDuplicate(s);
		System.out.println("String after remove duplicates is: " + ans);
		
		sc.close();
	}
}
