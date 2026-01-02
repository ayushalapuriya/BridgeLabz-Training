import java.util.Scanner;
public class TextEditingTool {
	
	// Method to edit text with given rules
	public static String textEditing(String text) {
        text=text.trim().replaceAll("\\s+", " "); // remove extra spaces
        StringBuilder result=new StringBuilder();
        boolean capitalizeNext=true;
        for(int i=0;i<text.length();i++) {
            char c=text.charAt(i);
            if(capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext=false;
            } else {
                result.append(c);
            }

            // After punctuation, ensure one space and capitalize next letter
            if(c=='.' || c=='!' || c=='?') {
                capitalizeNext = true;
                if(i+1<text.length() && text.charAt(i+1)!=' ') {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a paragraph: ");
		String text=sc.nextLine();
		
		String result=textEditing(text);
		
		// Display output
		System.out.println("Corrected version of text is: "+result.trim());
		sc.close();
	}
}
