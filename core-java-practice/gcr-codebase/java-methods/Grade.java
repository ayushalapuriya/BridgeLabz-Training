import java.util.*;
public class Grade {

    // Method to generate random 2-digit scores for Physics, Chemistry, and Math
    public static int[][] generateScores(int numStudents) {
        int[][] scores=new int[numStudents][3];
        for(int i=0;i<numStudents;i++) {
            scores[i][0]=(int)(Math.random()*91)+10;
            scores[i][1]=(int)(Math.random()*91)+10;
            scores[i][2]=(int)(Math.random()*91)+10;
        }
        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        int numStudents=scores.length;
        double[][] results=new double[numStudents][3];
        for(int i=0;i<numStudents;i++) {
            int total=scores[i][0]+scores[i][1]+scores[i][2];
            double average=(double)total/3;
            double percentage=(double)total/300*100;
            results[i][0]=Math.round(total*100.0)/100.0;
            results[i][1]=Math.round(average*100.0)/100.0;
            results[i][2]=Math.round(percentage*100.0)/100.0;
        }
        return results;
    }

    // Method to get grade based on percentage
    public static String getGrade(double percentage) {
        if(percentage>=80) return "A";
        else if(percentage>=70) return "B";
        else if(percentage>=60) return "C";
        else if(percentage>=50) return "D";
        else if(percentage>=40) return "E";
        else return "R";
    }

    // Method to display the scorecard of all students
    public static void displayScorecard(int[][] scores,double[][] results) {
        System.out.println("\n=== Student Scorecard ===");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------------");
        for(int i=0;i<scores.length;i++) {
            int physics=scores[i][0];
            int chemistry=scores[i][1];
            int math=scores[i][2];
            double total=results[i][0];
            double average=results[i][1];
            double percentage=results[i][2];
            String grade=getGrade(percentage);
            System.out.println((i+1)+"\t"+physics+"\t"+chemistry+"\t\t"+math+"\t"+total+"\t"+average+"\t"+percentage+"%\t\t"+grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.print("Enter number of students: ");
        int numStudents=sc.nextInt();

        // Generate random scores
        int[][] scores=generateScores(numStudents);

        // Calculate results
        double[][] results=calculateResults(scores);

        // Display scorecard
        displayScorecard(scores,results);

        sc.close();
    }
}
