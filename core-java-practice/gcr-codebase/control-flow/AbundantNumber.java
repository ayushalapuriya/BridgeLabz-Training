import java.util.Scanner;

public class AbundantNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 1; i < 12; i++) {
			if (num % i == 0)
				sum += i;
		}
		if (sum > num) {
			System.out.println("The number " + num + " is abundant number");
		} else {
			System.out.println("The number " + num + " is not abundant number");
		}
		sc.close();
	}
}