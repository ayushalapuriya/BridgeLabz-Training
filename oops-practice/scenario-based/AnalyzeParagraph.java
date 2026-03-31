import java.util.Scanner;
public class AnalyzeParagraph {
	
	// Method to count words
	public static int countWords(String text) {
		String[]words=text.split(" ");
		return words.length;
	}
	
	// Method to find longest word
	public static String findLong(String text) {
		String[]words=text.split(" ");
		int len=0;
		String ans="";
		for(String word:words) {
			if(word.length()>len) {
				len=word.length();
				ans=word;
			}
		}
		return ans;
	}
	
	// Method to replace word with another word
	public static String replaceWords(String text,String given,String replace) {
		String[]word=text.split(" ");
		for(int i=0;i<word.length;i++) {
			if(word[i].equalsIgnoreCase(given)) word[i]=replace;
		}
		return String.join(" ",word);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a paragraph: ");
		String text=sc.nextLine();
		
		// Check empty
		text=text.trim().replaceAll("\\s+", " ");
		if(text.isEmpty()) System.out.println("String is empty");
		else {
			String specificWord=sc.next();
			String replaceWord=sc.next();
			System.out.println("Count the number of words in the paragraph is: "+countWords(text));
			System.out.println("Longest word in paragraph is: "+findLong(text));
			System.out.println("Result after replacing word is: "+replaceWords(text,specificWord,replaceWord));
		}
		sc.close();
	}
}
