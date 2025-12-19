import java.util.*;
public class FindFactorialUsingWhileLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		double result=1;
		if(input>0) {
			System.out.println(input+" is natural number");
			while(input>0) {
				result*=input;
				input--;
			}
			System.out.println("The factorial of number "+input+" is: "+result);
		}
		else System.out.println(input+" is not natural number");
		sc.close();
	}
}
