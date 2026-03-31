import java.util.Scanner;

public class CalculateBMI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double weight = sc.nextDouble(); // weight in kilogram
		double height = sc.nextDouble(); // height in centimeter
		double heightInMeter = height/100;
		
		double BMI = weight/(height*heightInMeter);
		if(BMI<=18.4) System.out.println("Status: Underweight");
		else if(BMI>18.4 && BMI<=24.9) System.out.println("Status: Normal");
		else if(BMI>25 && BMI<=39.9) System.out.println("Status: Overweight");
		else System.out.println("Status: Obese");		
		sc.close();
	}
}