import java.util.*;
public class CalculateWindChill {
	
	// Method to find wind chill
	public static double calculateWindChill(double temp, double windSpeed) {
		double windChill= 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * (Math.pow(windSpeed,0.16));
		return windChill;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.println("Enter temperature: ");
		double temperature=sc.nextDouble();
		System.out.println("Enter speed of wind: ");
		double windSpeed=sc.nextDouble();
		
		double result=calculateWindChill(temperature,windSpeed);
		
		// Display output
		System.out.println("Calculated wind chill is: "+result);
		sc.close();
	}
}
