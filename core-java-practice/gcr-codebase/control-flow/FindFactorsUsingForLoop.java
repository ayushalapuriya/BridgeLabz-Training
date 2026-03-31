import java.util.*;
public class FindFactorsUsingForLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.print("Factors of number "+num+" are: ");
		for(int i=1;i<num;i++) {
			if(num%i==0) System.out.print(i+" ");
		}
		sc.close();
	}
}
