import java.util.*;
public class GradeBased {
	
	// generate random 2-digit scores for PCM
	public static int[][] generateScores(int n){
		int[][] scores=new int[n][3];
		for(int i=0;i<n;i++){
			scores[i][0]=(int)(Math.random()*91)+10; // physics 10-100
			scores[i][1]=(int)(Math.random()*91)+10; // chemistry 10-100
			scores[i][2]=(int)(Math.random()*91)+10; // maths 10-100
		}
		return scores;
	}
	
	// calculate total, average, percentage
	public static double[][] calculateStats(int[][] scores){
		int n=scores.length;
		double[][] stats=new double[n][3];
		for(int i=0;i<n;i++){
			int total=scores[i][0]+scores[i][1]+scores[i][2];
			double avg=total/3.0;
			double per=(total/300.0)*100;
			stats[i][0]=Math.round(total*100.0)/100.0;
			stats[i][1]=Math.round(avg*100.0)/100.0;
			stats[i][2]=Math.round(per*100.0)/100.0;
		}
		return stats;
	}
	
	// calculate grade based on percentage
	public static String[] calculateGrade(double[][] stats){
		int n=stats.length;
		String[] grades=new String[n];
		for(int i=0;i<n;i++){
			double per=stats[i][2];
			if(per>=80) grades[i]="A";
			else if(per>=70) grades[i]="B";
			else if(per>=60) grades[i]="C";
			else if(per>=50) grades[i]="D";
			else if(per>=40) grades[i]="E";
			else grades[i]="R";
		}
		return grades;
	}
	
	// display scorecard
	public static void displayScorecard(int[][] scores, double[][] stats, String[] grades){
		System.out.println("Student\t Physics\t Chemistry\t Maths\t Total\t Average\t Percentage\t Grade");
		for(int i=0;i<scores.length;i++){
			System.out.println((i+1)+"\t "+scores[i][0]+"\t "+scores[i][1]+"\t\t "+scores[i][2]+"\t "+(int)stats[i][0]+"\t "+stats[i][1]+"\t "+stats[i][2]+"\t\t "+grades[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input 
		System.out.print("Enter number of students: ");
		int n=sc.nextInt();
		
		int[][] scores=generateScores(n);
		double[][] stats=calculateStats(scores);
		String[] grades=calculateGrade(stats);
		displayScorecard(scores,stats,grades);
		
		sc.close();
	}
}
