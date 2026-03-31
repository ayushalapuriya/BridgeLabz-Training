import java.util.Scanner;
public class ShortestAndLongest {
	
	//Find shortest & longest word indexes
	public static int[] search(String[][] array) {
	    int min=0,max=0;

	    for(int i=1;i<array.length;i++) {
	        int len=Integer.parseInt(array[i][1]);
	        if(len<Integer.parseInt(array[min][1])) min=i;
	        if(len>Integer.parseInt(array[max][1])) max=i;
	    }
	     int a[]=new int[2];
	        a[0]=min;
	        a[1]=max;
	        return a;
	}
	
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
	
	// COnvert 1D array to 2D
	public static String[][] convertArr(String[]result){
		String[][]ans=new String[result.length][2];
		int i=0;
		for(String s:result) {
			ans[i][0]=s;
			ans[i][1]=String.valueOf(findLength(s));
			i++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input text 
		String text=sc.nextLine();
		
		// Find split text
		String[] result=splitText(text);
		String[][]allWords=convertArr(result);
		
		// Display result
		System.out.println("Words are: ");
		for(int i=0;i<allWords.length;i++) System.out.println(allWords[i][0]+"	"+allWords[i][1]);
		
		int[]sl=search(allWords);
		System.out.println("The shortest length index is: "+sl[0]+" and longest length index is: "+sl[1]);
		
		sc.close();
	}
}
