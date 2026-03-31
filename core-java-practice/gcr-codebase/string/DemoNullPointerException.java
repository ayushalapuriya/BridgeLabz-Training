
public class DemoNullPointerException {
	
	// Method to generate exception
	public static void generateException(String str) {
		System.out.println(str.length());
	}
	
	// Method to handle exception
	public static void handleException(String str) {
		try {
			System.out.println(str.length());
		}
		catch(NullPointerException e) {
			System.out.println("Handle NullPointerException");
		}
	}
	
	public static void main(String[] args) {
		String str=null;
		
		// Generating exception
		try {
			generateException(str);
		}
		catch(NullPointerException e){
			System.out.println("Exception caught");
		}
		
		// Handle exception
		handleException(str);
	}
}
