import java.util.*;
public class BMIIn2DArray {
	
	// Method to find BMI and its status
	public static String[][] findBMI(double[][]persons){
		String[][]BMIStats=new String[10][2];
		for(int i=0;i<10;i++) {
			double heightInM=persons[i][1]/100;
			double bmi=persons[i][0]/(heightInM*heightInM);
			BMIStats[i][0]=String.valueOf(bmi);
			if(bmi<=18.4) BMIStats[i][1]="Underweight";
			else if(bmi>=18.5 && bmi<=24.9) BMIStats[i][1]="Normal";
			else if(bmi>=25.0 && bmi<=39.9) BMIStats[i][1]="Overweight";
			else BMIStats[i][1]="Obese";
		}
		return BMIStats;
	}

	// Method to make scorecard combine weight, height, bmi and bmi status
	public static String[][] makeScorecard(double[][]persons,String[][]BMIStats){
		String[][]scorecard=new String[10][4];
		for(int i=0;i<10;i++) {
			scorecard[i][0]=String.valueOf(persons[i][0]);  // weight
			scorecard[i][1]=String.valueOf(persons[i][1]);  // height
			scorecard[i][2]=BMIStats[i][0];  // bmi
			scorecard[i][3]=BMIStats[i][1];  // bmi status
		}
		return scorecard;
	}
	
	// Method to display scorecard
	public static void displayScorecard(String[][]scorecard) {
		System.out.println("\n============== BMI SCORECARD ==============");
		System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
		System.out.println("==============================================");
		for(int i=0;i<10;i++) {
			System.out.println((i+1)+"\t"+scorecard[i][0]+"\t\t"+scorecard[i][1]+"\t\t"+scorecard[i][2]+"\t"+scorecard[i][3]);
		}
		System.out.println("==============================================");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double[][]persons=new double[10][2];
		
		// Input
		for(int i=0;i<10;i++) {
			System.out.print("Enter weight in kg and height in cm of "+i+"th"+" person is: ");
			persons[i][0]=sc.nextDouble();
			persons[i][1]=sc.nextDouble();
		}
		
		String[][]BMIStats=findBMI(persons);
		
		// Make scorecard combining all data
		String[][]scorecard=makeScorecard(persons,BMIStats);
		
		// Display scorecard
		displayScorecard(scorecard);
		
		sc.close();
	}
}
