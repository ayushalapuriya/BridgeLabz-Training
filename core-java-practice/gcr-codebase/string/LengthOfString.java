import java.util.*;
public class LengthOfString {
	
	// Method to find length without in built method
	public static int findLength(String str) {
		int count=0;
		try {
			while(true) {
				str.charAt(count);
				count++;
			}
		}
		catch(Exception e) {
			return count;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		int result1=findLength(str);
		int result2=str.length();
		
		// Display result
		System.out.println("Length by user defined method is: "+result1);
		System.out.println("Length by predefined method is: "+result2);
		sc.close();
	}
}
