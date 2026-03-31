import java.util.Scanner;

public class CalculateMayaBMI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("What is Your Weight in Kg: ");
		double weight = sc.nextDouble();

		System.out.print("What is Your Height in M: ");
		double height = sc.nextDouble();
		double BMI = weight / (height * height);
		if (BMI <= 18.4)
			System.out.println("Status: Underweight");
		else if (BMI > 18.4 && BMI <= 24.9)
			System.out.println("Status: Normal");
		else if (BMI > 25 && BMI <= 39.9)
			System.out.println("Status: Overweight");
		else
			System.out.println("Status: Obese");
		sc.close();
	}
}