import java.util.*;
public class MultiplicationTable1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input a number
		int num=sc.nextInt();
		
		// Declare a 1D array of 10 length
		int[]result=new int[10];
		
		// Calculation multiplication table and stored in result array
		for(int i=1;i<=10;i++) {
			result[i-1]=num*i;
		}
		
		// Display the result
		for(int i=0;i<10;i++) System.out.println(num+" * "+(i+1)+" = "+result[i]);
		sc.close();
	}
}
