import java.util.*;

public class CheckSignNoAndCompareFirstLast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Declare 1D array of 5 length
		int[] num = new int[5];

		// Input numbers
		for (int i = 0; i < 5; i++)
			num[i] = sc.nextInt();

		// Check even or odd if no is positive else print negative or zero
		for (int i = 0; i < 5; i++) {
			if (num[i] > 0) {
				if (num[i] % 2 == 0)
					System.out.println(num[i] + " is positive even number");
				else
					System.out.println(num[i] + " is positive odd number");
			} else if (num[i] < 0)
				System.out.println(num[i] + " is negative number");
			else
				System.out.println(num[i] + " is zero");
		}

		// Check first element is equal or greater or less compare with last element
		if (num[0] == num[4])
			System.out.println("Equal number");
		else if (num[0] < num[4])
			System.out.println(num[0] + " is less than " + num[4]);
		else
			System.out.println(num[0] + " is greater than " + num[4]);
		sc.close();
	}
}
