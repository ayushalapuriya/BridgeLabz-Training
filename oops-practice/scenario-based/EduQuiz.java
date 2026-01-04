import java.util.Scanner;
public class EduQuiz {
	
	// Method to calculate score
	public static int calculateScore(String[]correct,String[]student) {
		int score=0;
		for(int i=0;i<correct.length;i++) {
			if(correct[i].equalsIgnoreCase(student[i])) {
				score++;
			}
		}
		return score;
	}
	
	// Method to display detailed feedback
	public static void displayFeedback(String[]correct,String[]student) {
		System.out.println("\n--- Detailed Feedback ---");
		for(int i=0;i<correct.length;i++) {
			System.out.print("Question "+(i+1)+": ");
			if(correct[i].equalsIgnoreCase(student[i])) {
				System.out.println("Correct ✓");
			} else {
				System.out.println("Incorrect ✗ (Correct answer: "+correct[i]+", Your answer: "+student[i]+")");
			}
		}
	}
	
	// Method to calculate percentage
	public static double calculatePercentage(int score,int total) {
		return (score*100.0)/total;
	}
	
	// Method to determine pass or fail
	public static String getPassFailStatus(double percentage) {
		if(percentage>=60) {
			return "PASS";
		} else {
			return "FAIL";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Correct answers for 10 questions
		String[]correctAnswers={"A","B","C","D","A","B","C","D","A","B"};
		
		// Student answers array
		String[]studentAnswers=new String[10];
		
		// Display quiz instructions
		System.out.println("=== EduQuiz - Student Quiz Grader ===");
		System.out.println("Answer 10 questions (Enter A, B, C, or D)\n");
		
		// Input student answers
		for(int i=0;i<10;i++) {
			System.out.print("Question "+(i+1)+": ");
			studentAnswers[i]=sc.next().trim();
			
			// Validate input
			while(!studentAnswers[i].equalsIgnoreCase("A") && 
			      !studentAnswers[i].equalsIgnoreCase("B") && 
			      !studentAnswers[i].equalsIgnoreCase("C") && 
			      !studentAnswers[i].equalsIgnoreCase("D")) {
				System.out.print("Invalid input! Enter A, B, C, or D: ");
				studentAnswers[i]=sc.next().trim();
			}
		}
		
		// Calculate score
		int score=calculateScore(correctAnswers,studentAnswers);
		
		// Calculate percentage
		double percentage=calculatePercentage(score,correctAnswers.length);
		
		// Get pass/fail status
		String status=getPassFailStatus(percentage);
		
		// Display detailed feedback
		displayFeedback(correctAnswers,studentAnswers);
		
		// Display final results
		System.out.println("\n--- Quiz Results ---");
		System.out.println("Total Questions: "+correctAnswers.length);
		System.out.println("Correct Answers: "+score);
		System.out.println("Incorrect Answers: "+(correctAnswers.length-score));
		System.out.println("Percentage Score: "+String.format("%.2f",percentage)+"%");
		System.out.println("Status: "+status);
		
		// Display performance message
		if(percentage>=90) {
			System.out.println("Excellent work! Outstanding performance!");
		} else if(percentage>=75) {
			System.out.println("Great job! Very good performance!");
		} else if(percentage>=60) {
			System.out.println("Good effort! You passed the quiz!");
		} else {
			System.out.println("Keep practicing! You need to score at least 60% to pass.");
		}
		
		sc.close();
	}
}
