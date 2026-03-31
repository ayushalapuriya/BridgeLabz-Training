import java.util.Scanner;
public class ManageStudentScore {
	
	// Method to calculate average score
	public static double calculateAverage(double[]scores) {
		double sum=0;
		for(double score:scores) {
			sum+=score;
		}
		return sum/scores.length;
	}
	
	// Method to find highest score
	public static double findHighest(double[]scores) {
		double max=scores[0];
		for(int i=1;i<scores.length;i++) {
			if(scores[i]>max) {
				max=scores[i];
			}
		}
		return max;
	}
	
	// Method to find lowest score
	public static double findLowest(double[]scores) {
		double min=scores[0];
		for(int i=1;i<scores.length;i++) {
			if(scores[i]<min) {
				min=scores[i];
			}
		}
		return min;
	}
	
	// Method to find scores above average
	public static void findScoresAboveAverage(double[]scores,double average) {
		System.out.println("\nScores above average ("+String.format("%.2f",average)+"):");
		boolean found=false;
		for(int i=0;i<scores.length;i++) {
			if(scores[i]>average) {
				System.out.println("Student "+(i+1)+": "+String.format("%.2f",scores[i]));
				found=true;
			}
		}
		if(!found) {
			System.out.println("No scores above average");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input for number of students
		System.out.print("Enter number of students: ");
		int n=0;
		try {
			n=sc.nextInt();
			if(n<=0) {
				System.out.println("Error: Number of students must be positive");
				sc.close();
				return;
			}
		} catch(Exception e) {
			System.out.println("Error: Invalid input. Please enter a valid number");
			sc.close();
			return;
		}
		
		// Create array to store scores
		double[]scores=new double[n];
		
		// Input scores with validation
		System.out.println("Enter test scores for "+n+" students:");
		for(int i=0;i<n;i++) {
			System.out.print("Student "+(i+1)+" score: ");
			try {
				double score=sc.nextDouble();
				if(score<0) {
					System.out.println("Error: Score cannot be negative");
					i--;
					continue;
				}
				scores[i]=score;
			} catch(Exception e) {
				System.out.println("Error: Invalid input. Please enter a valid number");
				sc.next(); // Clear invalid input
				i--;
			}
		}
		
		// Calculate average
		double average=calculateAverage(scores);
		
		// Find highest and lowest
		double highest=findHighest(scores);
		double lowest=findLowest(scores);
		
		// Display output
		System.out.println("\n--- Student Score Analysis ---");
		System.out.println("Total students: "+n);
		System.out.println("Average score: "+String.format("%.2f",average));
		System.out.println("Highest score: "+String.format("%.2f",highest));
		System.out.println("Lowest score: "+String.format("%.2f",lowest));
		
		// Display scores above average
		findScoresAboveAverage(scores,average);
		
		sc.close();
	}
}
