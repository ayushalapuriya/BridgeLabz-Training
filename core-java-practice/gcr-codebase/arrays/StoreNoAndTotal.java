import java.util.*;
public class StoreNoAndTotal {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Declare 1D array which only store positive numbers
		double[]arr=new double[10];
		double total=0.0;
		int index=0;
		
		// Input values
		while(true) {
			double num=sc.nextDouble();
			if(num<=0 || index==10) break;
			arr[index]=num;
			index++;
		}
		
		// Total of elements in array
		for(int i=0;i<10;i++) total+=arr[i];
		
		// Display total
		System.out.println("The total is: "+total);
		sc.close();
	}
}
