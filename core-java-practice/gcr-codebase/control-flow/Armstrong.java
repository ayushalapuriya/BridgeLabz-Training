import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // 153-> 1^3 + 5^3 + 3^3 27+125+1->153
		int temp = number;
		int sum = 0;
		while (number > 0) {
			int digit = number % 10;
			sum = sum + (digit * digit * digit);
			number = number / 10;
		}
		if (sum == temp) {
			System.out.println("Yes The number " + temp + " is an Armstrong number");
		} else {
			System.out.println("Yes The number " + temp + " is not an Armstrong number");
		}
		sc.close();
	}
}