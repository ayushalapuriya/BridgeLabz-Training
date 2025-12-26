import java.util.Scanner;
public class ReplaceWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a sentence: ");
		String str=sc.nextLine();
		System.out.print("Enter a word from given sentence: ");
		String word=sc.next();
		System.out.print("Enter new word: ");
		String newWord=sc.next();
		
		// Replace a given word from another word
		String[]words=str.split(" ");
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(word)) {
				words[i]=newWord;
			}
		}
		
		System.out.println("Updated sentence: "+String.join(" ",words));
		
		sc.close();
	}
}
