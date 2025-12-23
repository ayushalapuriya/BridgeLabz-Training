import java.util.*;
public class DemoNumberFormatException {
	
	// Method to generate exception
	public static void generateException(String text) {
		System.out.println(Integer.parseInt(text));
	}

	// Method to handle exception
	public static void handleException(String text) {
		try {
			generateException(text);
		}
		catch(NumberFormatException e) {
			System.out.println("Number Format Exception Handled");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String text=sc.next();

		// generateException(text); // removing comment will cause runtime exception
		handleException(text);

		sc.close();
	}
}
