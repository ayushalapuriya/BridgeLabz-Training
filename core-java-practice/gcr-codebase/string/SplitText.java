import java.util.*;
public class SplitText {
	
	// Find length
	public static int findLength(String text) {
		int count=0;
		for(char ch:text.toCharArray()) {
			count++;
		}
		return count;
	}
	
	// Split text by user defined method
	public static String[] splitText(String text) {
		int len=findLength(text);
		int countWord=1;
		for(int i=0;i<len;i++) {
			if(text.charAt(i)==' ') countWord++;
		}
		int[]charIndex=new int[countWord+1];
		int idx=0;
		charIndex[idx++]=-1;
		for(int i=0;i<len;i++) {
			if(text.charAt(i)==' ') charIndex[idx++]=i;
		}
		charIndex[idx]=len;
		
		String[]words=new String[countWord];
		for(int i=0;i<countWord;i++) {
			String word=text.substring(charIndex[i]+1,charIndex[i+1]);
			words[i]=word;
		}
		return words;
	}
	
	// Compare both array
	public static boolean compare(String[]a1,String[]a2) {
        if(a1.length!=a2.length) return false;

        for (int i = 0; i < a1.length; i++) {
            if (!a1[i].equals(a2[i])) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input text 
		String text=sc.nextLine();
		
		// Find split text by both method
		String[] result=splitText(text);
		String[] result1=text.split(" ");
		
		// Display result
		System.out.println("After comparing both array result is: "+compare(result,result1));
		System.out.println("Words are: ");
		for(String s:result) System.out.println(s);
		
		sc.close();
	}
}
