import java.util.*;
public class MultiplesUnder100 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0 && num<100) {
			System.out.print("All multiples of "+num+" are: ");
			for(int i=99;i>0;i--) {
				if(i%num==0) System.out.print(i+" ");
			}
		}
		else System.out.println("Out of range");
		sc.close();
	}
}
