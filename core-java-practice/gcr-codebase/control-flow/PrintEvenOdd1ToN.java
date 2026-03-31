import java.util.*;
public class PrintEvenOdd1ToN {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0) {
			System.out.println(num+" is natural number");
			for(int i=1;i<=num;i++) {
				if(i%2==0) System.out.println(i+" is Even");
				else System.out.println(i+" is Odd");
			}
		}
		else System.out.println(num+" is not natural number");
		sc.close();
	}
}
