import java.util.Scanner;

public class EduQuiz {
    // Calculate score
    public static int calculateScore(String[] correct,String[] student) {
        int score=0;
        for(int i=0;i<correct.length;i++) {
            if(correct[i].equalsIgnoreCase(student[i])) score++;
        }
        return score;
    }

    // Display detailed feedback
    public static void displayFeedback(String[] correct,String[] student) {
        System.out.println("\n--- Detailed Feedback ---");
        for(int i=0;i<correct.length;i++) {
            System.out.print("Question "+(i+1)+": ");
            if(correct[i].equalsIgnoreCase(student[i])) System.out.println("Correct ✓");
            else System.out.println("Incorrect ✗ (Correct: "+correct[i]+", Your answer: "+student[i]+")");
        }
    }

    // Calculate percentage
    public static double calculatePercentage(int score,int total) {
        return (score*100.0)/total;
    }

    // Pass or Fail
    public static String getPassFailStatus(double percentage) {
        return (percentage>=60)?"PASS":"FAIL";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] correctAnswers={"A","B","C","D","A","B","C","D","A","B"};
        String[] studentAnswers=new String[10];

        System.out.println("=== EduQuiz - Student Quiz Grader ===");
        System.out.println("Answer 10 questions (Enter A,B,C,D)");

        // Input student answers
        for(int i=0;i<10;i++) {
            System.out.print("Question "+(i+1)+": ");
            studentAnswers[i]=sc.next().trim();
            while(!studentAnswers[i].equalsIgnoreCase("A") &&
                  !studentAnswers[i].equalsIgnoreCase("B") &&
                  !studentAnswers[i].equalsIgnoreCase("C") &&
                  !studentAnswers[i].equalsIgnoreCase("D")) {
                System.out.print("Invalid! Enter A,B,C,D: ");
                studentAnswers[i]=sc.next().trim();
            }
        }

        int score=calculateScore(correctAnswers,studentAnswers);
        double percentage=calculatePercentage(score,correctAnswers.length);
        String status=getPassFailStatus(percentage);

        displayFeedback(correctAnswers,studentAnswers);

        System.out.println("\n--- Quiz Results ---");
        System.out.println("Total Questions: "+correctAnswers.length);
        System.out.println("Correct Answers: "+score);
        System.out.println("Incorrect Answers: "+(correctAnswers.length-score));
        System.out.println("Percentage: "+String.format("%.2f",percentage)+"%");
        System.out.println("Status: "+status);

        // Performance message
        if(percentage>=90) System.out.println("Excellent! Outstanding!");
        else if(percentage>=75) System.out.println("Great job! Very good!");
        else if(percentage>=60) System.out.println("Good effort! You passed!");
        else System.out.println("Keep practicing! You need 60% to pass.");

        sc.close();
    }
}
