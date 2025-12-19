import java.util.*;
public class MaximumNumOfHandshake {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int maxHandshake=(n*(n-1))/2;
		System.out.println(maxHandshake);
		sc.close();
	}
}
