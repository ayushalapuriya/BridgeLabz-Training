import java.util.*;
public class PowerOfNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double num=sc.nextDouble();
		int power=sc.nextInt();
		double result=1;
		for(int i=1;i<=power;i++) {
			result*=num;
		}
		System.out.println("Result is: "+result);
		sc.close();
	}
}
