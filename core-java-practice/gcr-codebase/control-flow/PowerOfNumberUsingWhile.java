import java.util.*;
public class PowerOfNumberUsingWhile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double num=sc.nextDouble();
		int power=sc.nextInt();
		double result=1;
		int i=1;
		while(i<=power) {
			result*=num;
			i++;
		}
		System.out.println("The result is: "+result);
		sc.close();
	}
}
