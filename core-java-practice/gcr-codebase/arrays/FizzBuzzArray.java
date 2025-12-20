import java.util.*;

public class FizzBuzzArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input number
		int number = sc.nextInt();

		// Declare 1D array
		String[] result = new String[number + 1];

		// Check positive then check divisible by 3 or 5 or both
		for (int i = 0; i <= number; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				result[i] = "FizzBuzz";
			else if (i % 3 == 0)
				result[i] = "Fizz";
			else
				result[i] = "Buzz";
		}

		// Display result
		System.out.print("Elements of array are: ");
		for (int i = 0; i < number + 1; i++)
			System.out.print(result[i] + " ");
		sc.close();
	}
}
