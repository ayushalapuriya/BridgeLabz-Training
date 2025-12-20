import java.util.*;

public class EvenOddToArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input number
		int number = sc.nextInt();

		// Declare 2 1D array to store odd and even
		int size = number / 2 + 1;
		int[] odd = new int[size];
		int[] even = new int[size];

		// Even or Odd and put in array
		int oddIndex = 0;
		int evenIndex = 0;
		for (int i = 1; i <= number; i++) {
			if (i % 2 == 0)
				even[evenIndex++] = i;
			else
				odd[oddIndex++] = i;
		}

		// Display odd array
		System.out.print("Odd array elements are: ");
		for (int i = 0; i < oddIndex; i++)
			System.out.print(odd[i] + " ");
		System.out.println();

		// DIsplay even array
		System.out.print("Even array elements are: ");
		for (int i = 0; i < evenIndex; i++)
			System.out.print(even[i] + " ");
		sc.close();
	}
}
