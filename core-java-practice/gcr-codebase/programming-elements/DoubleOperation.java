import java.util.*;
public class DoubleOperation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		double c=sc.nextDouble();
		double opr1=a+b*c;
		double opr2=a*b+c;
		double opr3=a+b/c;
		double opr4=a%b+c;
		System.out.println("The results of Int Operations are "+opr1+" , "+opr2+" , "+opr3+" and "+opr4);
		sc.close();
	}
}
