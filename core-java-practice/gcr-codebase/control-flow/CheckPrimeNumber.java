import java.util.*;
public class CheckPrimeNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				System.out.println(num+" is not a prime number");
				break;
			}
			else {
				System.out.println(num+" is a prime number");
				break;
			}
		}
		sc.close();
	}
}
