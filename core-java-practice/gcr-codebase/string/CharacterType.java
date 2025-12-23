import java.util.*;
public class CharacterType {
	
	// Method to check character type
	public static String checkCharType(char character) {
		// Convert uppercase to lowercase using ASCII
		if(character>='A' && character<='Z') {
			character=(char)(character+32);
		}
		
		// Check if letter
		if(character>='a' && character<='z') {
			// Check if vowel
			if(character=='a' || character=='e' || character=='i' || character=='o' || character=='u') return "Vowel";
			else return "Consonant";
		}
		return "Not a Letter";
	}
	
	// Method to analyze characters and return 2D array
	public static String[][] separateCharacters(String inputText) {
		String[][] charData=new String[inputText.length()][2];
		
		for(int index=0; index<inputText.length(); index++) {
			char currentChar=inputText.charAt(index);
			charData[index][0]=String.valueOf(currentChar);
			charData[index][1]=checkCharType(currentChar);
		}
		return charData;
	}
	
	// Method to display 2D array in tabular format
	public static void displayTable(String[][] tableData) {
		System.out.println("Character Type");
		for(int row=0; row<tableData.length; row++) {
			System.out.println(tableData[row][0]+"\t\t"+tableData[row][1]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input string
		String str=sc.nextLine();
		String[][] result=separateCharacters(str);
		
		// Display result in tabular format
		displayTable(result);
		
		sc.close();
	}
}