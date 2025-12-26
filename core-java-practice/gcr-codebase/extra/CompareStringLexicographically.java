import java.util.*;
public class CompareStringLexicographically {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter first string: ");
		String str1=sc.next();
		System.out.print("Enter second string: ");
		String str2=sc.next();
		
		// Compare two string in lexicographically order and display output
		if(str1.equals(str2)) {
			System.out.println("Both are same");
			return;
		}
		int i=0,j=0;
		while(i<str1.length() && j<str2.length()) {
			if(str1.charAt(i)<str2.charAt(j)) {
				System.out.println(str1+" comes before "+str2+" in lexicographical order");
				return;
			}
			else if(str2.charAt(i)<str1.charAt(j)) {
				System.out.println(str2+" comes before "+str1+" in lexicographical order");
				return;
			}
			else {
				i++;
				j++;
			}
		}
		if(i<str1.length()) System.out.println(str2+" comes before "+str1+" in lexicographical order");
		else System.out.println(str1+" comes before "+str2+" in lexicographical order");
		
		sc.close();
	}
}
