import java.util.*;
public class DemoStringIndexOutOfBoundsException {
	
	// Method to generate exception
	public static void generateException(String str) {
		System.out.println(str.charAt(str.length()));
	}
	
	// Method to handle exception
	public static void handleException(String str) {
		try {
			generateException(str);
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("String index out of bounds exception handeled");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String text=sc.next();
	
		// Generating exception
		try {
			generateException(text);
		}
		catch(NullPointerException e){
			System.out.println("Exception caught");
		}
				
		// Handle exception
		handleException(text);
		sc.close();
	}
}
