import java.util.Scanner;
public class FibonacciSeqGenerator {
	
	// Method to generate fibonacci sequence
	public static int[] generateSequence(int num) {
		int[]ans=new int[num+1];
		ans[0]=0;
		ans[1]=1;
		for(int i=2;i<=num;i++) {
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans;
	}
	
	// Method to display sequence
	public static void display(int[]seq) {
		System.out.print("The fibonacci sequence is: ");
		for(int i:seq) System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a number: ");
		int num=sc.nextInt();
		
		int[]sequence=generateSequence(num);
		display(sequence);
		sc.close();
	}
}
