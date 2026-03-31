import java.util.*;
public class IsFirstSmallest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number1=sc.nextInt();
		int number2=sc.nextInt();
		int number3=sc.nextInt();
		if(number1<number2 && number1<number3) System.out.println("Yes, the first number "+number1+" is smallest");
		else System.out.println("No, the first number "+number1+" is not smallest");
		sc.close();
	}
}
