import java.util.*;
public class FindFactorsUsingWhileLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.print("Factors of number "+num+" are: ");
		int i=1;
		while(i<num) {
			if(num%i==0) System.out.print(i+" ");
			i++;
		}
		sc.close();
	}
}
