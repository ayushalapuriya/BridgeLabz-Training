import java.util.*;
public class LeapYearUsingIfElse {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		if(year<1582) System.out.println("Enter valid input");
		else if(year%4==0 && year%100!=0) System.out.println(year+" is a leap year");
		else if(year%400==0) System.out.println(year+" is a leap year");
		else System.out.println(year+" is not  leap year");
		sc.close();
	}
}
