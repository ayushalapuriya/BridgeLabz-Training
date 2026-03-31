import java.util.*;
public class BonusOfEmployees {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int salary=sc.nextInt();
		int yearOfService=sc.nextInt();
		int bonus=0;
		if(yearOfService>5) {
			// bonus is 5 percent of salary
			bonus=(5*salary)/100;
			System.out.println("Bonus amount is: "+bonus);
		}
		sc.close();
	}
}
