import java.util.*;
public class MultipleUnder100UsingWhile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>0 && num<100) {
			System.out.print("Multiples of "+num+" are: ");
			int i=99;
			while(i>0) {
				if(i%num==0) System.out.print(i+" ");
				i--;
			}
		}
		else System.out.println("Out of range");
		sc.close();
	}
}
