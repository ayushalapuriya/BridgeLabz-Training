import java.util.*;
public class PrintQuotientAndRemainder {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int q=num1/num2;
		int r=num1%num2;
		System.out.println("The Quotient is: "+q+" and Reminder is: "+r+" of two number "+num1+" and "+num2);
		sc.close();
	}
}
