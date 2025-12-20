import java.util.*;
public class MultiDimensionArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input
		int rows=sc.nextInt();
		int columns=sc.nextInt();
		int[][]matrix=new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		
		// Convert 2D array into 1D array
		int idx=0;
		int[]array=new int[rows*columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				array[idx++]=matrix[i][j];
			}
		}
		
		// Display 1D array
		System.out.print("Elements of array are: ");
		for(int i=0;i<array.length;i++) System.out.print(array[i]+" ");
		sc.close();
	}
}
