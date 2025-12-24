import java.util.*;
public class RoundsOfPark {
	
	// Method to find round of park
	public static int findRound(int s1,int s2,int s3) {
		int perimeter=s1+s2+s3;
		int round=perimeter/5;
		return round;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println();
		int side1=sc.nextInt();
		int side2=sc.nextInt();
		int side3=sc.nextInt();
		
		int round=findRound(side1,side2,side3);
		
		// Display output
		System.out.println("Rounds completed by athelete are: "+round);
		sc.close();
	}
}
