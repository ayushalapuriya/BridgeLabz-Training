import java.util.Scanner;

public class CalculatorUsingSwitchCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		String oper = sc.next();

		switch (oper) {
		case "+":
			System.out.println(num1 + num2);
			break;

		case "-":
			System.out.println(num1 - num2);
			break;

		case "*":
			System.out.println(num1 * num2);
			break;

		case "/":
			if (num2 != 0) {
				System.out.println(num1 / num2);
			} else {
				System.out.println("Error");
			}
			break;

		default:
			System.out.println("Invalid");
		}

		sc.close();
	}
}