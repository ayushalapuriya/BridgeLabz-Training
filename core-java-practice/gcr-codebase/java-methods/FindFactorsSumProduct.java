import java.util.*;
public class FindFactorsSumProduct {
	
	// Method to factors 
	public static int[] findFactors(int num) {
		int len=0;
		for(int i=1;i<=num;i++) if(num%i==0) len++;
		
		int[]factors=new int[len];
		len=0;
		for(int i=1;i<=num;i++) if(num%i==0) factors[len++]=i;
		return factors;
	}
	
	// Method to find sum of factors
	public static long findSum(int[]arr) {
		long sum=0;
		for(int i:arr) sum+=i;
		return sum;
	}
	
	// Method to find product of factors
	public static long findPro(int[]arr) {
		long pro=1;
		for(int i:arr) pro*=i;
		return pro;
	}
	
	// Method to find sum of squares of factors
	public static long findSqSum(int[]arr) {
		long ans=0;
		for(int i:arr) ans+=(Math.pow(i, 2));
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter a number: ");
		int num=sc.nextInt();
		
		int[]factors=findFactors(num);
		long sum=findSum(factors);
		long pro=findPro(factors);
		long sqSum=findSqSum(factors);
		
		// Display output
		System.out.print("Factors of given number are: ");
		for(int i:factors) System.out.print(i+" ");
		System.out.println();
		System.out.println("Sum of factors is: "+sum);
		System.out.println("Product of factors is: "+pro);
		System.out.println("Sum of square of factors is: "+sqSum);
		
		sc.close();
	}
}
