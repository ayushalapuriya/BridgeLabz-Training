import java.util.*;
public class FizzBuzzUsingForLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0) {
			for(int i=1;i<=num;i++) {
				if(i%3==0 && i%5==0) System.out.println(i+" FizzBuzz");
				else if(i%3==0) System.out.println(i+" Fizz");
				else if(i%5==0) System.out.println(i+" Buzz");
				else System.out.println(i);
			}
		}
		else System.out.println("Not a positive number");
		sc.close();
	}
}
