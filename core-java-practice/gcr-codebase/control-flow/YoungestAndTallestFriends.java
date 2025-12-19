import java.util.*;
public class YoungestAndTallestFriends {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// let assume the names of three friends are first, second, and third
		// below are the user input age and height
		int firstAge=sc.nextInt();
		double firstHeight=sc.nextDouble();
		int secondAge=sc.nextInt();
		double secondHeight=sc.nextDouble();
		int thirdAge=sc.nextInt();
		double thirdHeight=sc.nextDouble();
		
		// find youngest friend
		if(firstAge<secondAge && firstAge<thirdAge) System.out.println("First friend is youngest");
		else if(secondAge<firstAge && secondAge<thirdAge) System.out.println("Second friend is youngest");
		else System.out.println("Third friend is youngest");
		
		// find tallest friend
		if(firstHeight>secondHeight && firstHeight>thirdHeight) System.out.println("First friend is tallest");
		else if(secondHeight>firstHeight && secondHeight>thirdHeight) System.out.println("Second friend is tallest");
		else System.out.println("Third friend is tallest");
		sc.close();
	}
}
