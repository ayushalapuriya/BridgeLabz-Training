import java.util.*;
public class CheckNaturalNoAndSum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n>=0) {
			System.out.println("Yes the number "+n+" is natural number");
			int sum=(n*(n+1))/2;
			System.out.println("The sum of "+n+" natural number is: "+sum);
		}
		else System.out.println("No the number "+n+" is not natural number");
		sc.close();
	}
}
