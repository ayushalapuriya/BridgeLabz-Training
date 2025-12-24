import java.util.*;
public class MaxHandshake {
	
	// Method to find to max handshake
	public static double findMax(int n) {
		double ans=(n*(n-1))/2;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter a number: ");
		int num=sc.nextInt();
		
		double handshake=findMax(num);
		
		// Display output
		System.out.println("Number of possible handshakes: "+handshake);
		sc.close();
	}
}
