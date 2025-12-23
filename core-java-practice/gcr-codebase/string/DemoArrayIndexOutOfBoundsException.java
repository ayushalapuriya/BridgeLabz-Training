import java.util.*;
public class DemoArrayIndexOutOfBoundsException {
	
	// Method to generate exception
	public static void generateException(String[] names) {
		System.out.println(names[names.length]);
	}

	// Method to handle exception
	public static void handleException(String[] names) {
		try {
			generateException(names);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds exception handled");
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] names = new String[n];
		for(int i = 0; i < n; i++) {
			names[i] = sc.next();
		}

		// generateException(names); // if removed, it will cause runtime exception
		handleException(names);

		sc.close();
	}
}
