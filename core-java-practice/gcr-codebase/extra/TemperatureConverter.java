import java.util.Scanner;
public class TemperatureConverter {
	
	// Convert Fahrenheit to Celsius
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit-32)*5/9;
	}
	
	// Convert Celsius to Fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius*9/5)+32;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Temperature Converter");
		System.out.println("1. Fahrenheit to Celsius");
		System.out.println("2. Celsius to Fahrenheit");
		System.out.print("Enter your choice: ");
		int choice=sc.nextInt();
		
		// Perform conversion
		if(choice==1) {
			System.out.print("Enter temperature in Fahrenheit: ");
			double fahrenheit=sc.nextDouble();
			double celsius=fahrenheitToCelsius(fahrenheit);
			System.out.println("Temperature in Celsius: "+celsius);
		}
		else if(choice==2) {
			System.out.print("Enter temperature in Celsius: ");
			double celsius=sc.nextDouble();
			double fahrenheit=celsiusToFahrenheit(celsius);
			System.out.println("Temperature in Fahrenheit: "+fahrenheit);
		}
		else {
			System.out.println("Invalid choice!");
		}
		
		sc.close();
	}
}
