import java.util.*;
public class AreaOfTriangle {
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		double base=sc.nextDouble();
		double height=sc.nextDouble();
		double area=0.5*base*height;
		double areaInInch=area/(2.54*2.54);
		double areaInFeet=areaInInch/144;
		System.out.println("Your Area in cm is: "+area+" while in feet is: "+areaInFeet+" and inches is: "+areaInInch);
		sc.close();
	 }
}
