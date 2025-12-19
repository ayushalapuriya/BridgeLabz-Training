import java.util.*;
public class SumOfNumberUntilZeroOrNegative {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double input=sc.nextDouble();
		double total=0.0;
		while(true) {
			total+=input;
			input=sc.nextDouble();
			if(input<=0) break;
		}
		System.out.println(total);
		sc.close();
	}
}
