import java.util.*;
public class MultiplicationTable2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input a number
		int num=sc.nextInt();
		
		// Declare a 1D array of 4 length
		int[]result=new int[4];
		
		// Calculation multiplication table and stored in result array
		int idx=0;
		for(int i=6;i<=9;i++) {
			result[idx]=num*i;
			idx++;
		}
		
		// Display the result
		idx=6;
		for(int i=0;i<4;i++) {
			System.out.println(num+" * "+(idx)+" = "+result[i]);
			idx++;
		}
		sc.close();
	}
}
