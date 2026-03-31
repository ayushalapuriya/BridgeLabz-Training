import java.util.Scanner;
public class MostFrequentChar {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.next();
		
		// Find frequency of character in string
		int[]freq=new int[256];
		for(char c:str.toCharArray()) freq[c]++;
		
		// Find most frequent character
		char most=str.charAt(0);
		int count=freq[most];
		for(int i=1;i<256;i++) {
			if(freq[i]>count) {
				most=(char)(i);
				count=freq[i];
			}
		}
		
		// Display output
		System.out.println("Most frequent character in string: "+most);
		
		sc.close();
	}
}
