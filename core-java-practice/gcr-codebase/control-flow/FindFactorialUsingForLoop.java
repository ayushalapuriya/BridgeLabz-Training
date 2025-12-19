import java.util.*;
public class FindFactorialUsingForLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=1;
		if(n>0) {
			System.out.println(n+" is natural number");
			for(int i=n;i>0;i--) {
				result*=i;
			}
			System.out.println("The factorial of number "+n+" is: "+result);
		}
		else System.out.println(n+" is not natural number");
		sc.close();
	}
}
