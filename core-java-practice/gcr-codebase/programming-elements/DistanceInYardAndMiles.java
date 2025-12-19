import java.util.*;
public class DistanceInYardAndMiles {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double distInFeet=sc.nextInt();
		double distInYard=distInFeet/3;
		double distInMiles=distInYard/1760;
		System.out.println("Distance in feet is: "+distInFeet+" while in yard is: "+distInYard+" and miles is: "+distInMiles);
		sc.close();
	}
}
