import java.util.*;
public class SumOfNaturalNoAndCompare2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n>0) {
			System.out.println("Yes it is natural number");
			int sumUsingFor=0;
			int sumUsingFormula=(n*(n+1))/2;
			for(int i=n;i>0;i--) sumUsingFor+=i;
			System.out.println("Sum by while loop is "+sumUsingFor+" and Sum by formula "+sumUsingFormula);
		}
		else System.out.println("Not natural number");
		sc.close();
	}
}
