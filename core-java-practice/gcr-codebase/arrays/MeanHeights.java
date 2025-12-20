import java.util.*;

public class MeanHeights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Declare 1D array of 11 length
		double[] heights = new double[11];

		// Input height in centimeter of 11 players
		for (int i = 0; i < 11; i++)
			heights[i] = (sc.nextDouble()) / 100; // centimeter to meter

		// Calculate sum of heights
		double totalSum = 0.0;
		for (int i = 0; i < 11; i++)
			totalSum += heights[i];

		// Calculate the mean
		double mean = totalSum / 11;

		// Display mean
		System.out.println("Mean heights of football team is: " + mean);
		sc.close();
	}
}
