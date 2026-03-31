import java.util.*;
public class IntOperations {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int opr1=a+b*c;
		int opr2=a*b+c;
		int opr3=a+b/c;
		int opr4=a%b+c;
		System.out.println("The results of Int Operations are "+opr1+" , "+opr2+" , "+opr3+" and "+opr4);
		sc.close();
	}
}
