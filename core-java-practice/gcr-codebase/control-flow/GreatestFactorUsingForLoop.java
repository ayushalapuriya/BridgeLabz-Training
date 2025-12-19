import java.util.*;
public class GreatestFactorUsingForLoop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int greatestFactor=1;
		for(int i=num-1;i>0;i--) {
			if(num%i==0) {
				greatestFactor=i;
				System.out.println("Greatest factor of "+num+" is: "+greatestFactor);
				break;
			}
		}
		sc.close();
	}
}
