import java.util.*;
public class BMI {

    // Method to calculate BMI for all persons
    public static void calculateBMI(double[][] data) {
        for(int i=0;i<data.length;i++) {
            double weight=data[i][0];
            double heightInCm=data[i][1];
            double heightInMeters=heightInCm/100;
            data[i][2]=weight/(heightInMeters*heightInMeters);
        }
    }

    // Method to determine BMI status
    public static String getBMIStatus(double bmi) {
        if(bmi<18.5) return "Underweight";
        else if(bmi>=18.5 && bmi<=24.9) return "Normal weight";
        else if(bmi>=25.0 && bmi<39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData=new double[10][3];

        // User input
        System.out.println("Enter details for 10 team members:");
        for(int i=0;i<10;i++) {
            System.out.print("Enter weight (kg) of person "+(i+1)+": ");
            teamData[i][0]=sc.nextDouble();
            System.out.print("Enter height (cm) of person "+(i+1)+": ");
            teamData[i][1]=sc.nextDouble();
        }

        calculateBMI(teamData);

        // Display output
        System.out.println("\nBMI Report:");
        for(int i=0;i<10;i++) {
            String status=getBMIStatus(teamData[i][2]);
            System.out.println("Person "+(i+1)+" - Weight: "+teamData[i][0]+" kg, Height: "+teamData[i][1]+" cm, BMI: "+teamData[i][2]+", Status: "+status);
        }

        sc.close();
    }
}
