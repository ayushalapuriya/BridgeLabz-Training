import java.util.*;
public class UniqueChar {
	
	// Find length
	public static int findLength(String text) {
		int count=0;
		for(char ch:text.toCharArray()) {
			count++;
		}
		return count;
	
	}
	
	// Unique characters
	public static char[] uniqueChar(String str) {
		int len=findLength(str);
		char[]temp=new char[len];
		int idx=0;
		// outer loop to pick each char
		for(int i=0;i<len;i++) {
			char currChar=str.charAt(i);
			boolean isUnique=true;
			
			// inner loop to check previous char
			for(int j=0;j<i;j++) {
				if(currChar==str.charAt(j)) {
					isUnique=false;
					break;
				}
			}
			if(isUnique) {
				temp[idx]=currChar;
				idx++;
			}
		}
		
		// Create final array with exact size
        char[] result = new char[idx];
        for(int i=0;i<idx;i++) result[i]=temp[i];
        return result;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.next();
		
		// Find unique char in string
		char[]uniques=uniqueChar(str);
		
		// Display unique char
		for(int i=0;i<uniques.length;i++) System.out.print(uniques[i]+" ");
	}
}
