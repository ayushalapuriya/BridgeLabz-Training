
public class PalindromeChecker {
	
	// Attribute
	String text;
	
	// Constructor
	PalindromeChecker(String text){
		this.text=text;
	}
	
	// Method to check palindrome
	boolean isPalindrome(){
		String cleanText=text.replaceAll("[^a-zA-Z]","").toLowerCase();
		String reversedText="";
		for(int i=cleanText.length()-1;i>=0;i--){
			reversedText=reversedText+cleanText.charAt(i);
		}
		return cleanText.equals(reversedText);
	}
	
	// Method to display result
	void displayResult(){
		if(isPalindrome()) System.out.println(text+" is palindrome");
		else System.out.println(text+" is not Palindrome");
	}
	
	public static void main(String[] args) {
		PalindromeChecker checker1=new PalindromeChecker("A man a plan a canal Panama");
		PalindromeChecker checker2=new PalindromeChecker("Hello");
		
		checker1.displayResult();
		checker2.displayResult();
	}
}
