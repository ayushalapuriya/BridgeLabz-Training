import java.util.*;
public class SumOfNaturalNoAndCompare {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n>0) {
			System.out.println("Yes it is natural number");
			int sumUsingWhile=0;
			int sumUsingFormula=(n*(n+1))/2;
			while(n>0) {
				sumUsingWhile+=n;
				n--;
			}
			System.out.println("Sum by while loop is "+sumUsingWhile+" and Sum by formula "+sumUsingFormula);
		}
		else System.out.println("Not natural number");
		sc.close();
	}
}
