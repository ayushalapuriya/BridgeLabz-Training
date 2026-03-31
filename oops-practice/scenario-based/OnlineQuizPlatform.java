import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception for invalid quiz submission
class InvalidQuizSubmissionException extends Exception{
    InvalidQuizSubmissionException(String message){
        super(message);
    }
}

public class OnlineQuizPlatform{
    // Method to calculate score and validate length
    public static int calculateScore(String[] correct,String[] student) throws InvalidQuizSubmissionException{
        if(correct.length != student.length){
            throw new InvalidQuizSubmissionException("Length mismatch!");
        }
        int score=0;
        for(int i=0;i<correct.length;i++){
            if(correct[i].equalsIgnoreCase(student[i])) score++; // count correct answers
        }
        return score;
    }

    // Method to calculate grade based on percentage
    public static String getGrade(double percentage){
        if(percentage>=90) return "A+";
        else if(percentage>=80) return "A";
        else if(percentage>=70) return "B";
        else if(percentage>=60) return "C";
        else return "F";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] correctAnswers={"A","B","C","D","A","B","C","D","A","B"}; // correct answers
        List<Integer> userScores=new ArrayList<>(); // store multiple users' scores

        System.out.print("Enter number of users: ");
        int numUsers=sc.nextInt();
        sc.nextLine(); // consume newline

        for(int user=1;user<=numUsers;user++){
            System.out.println("User "+user+":");
            String[] studentAnswers=new String[correctAnswers.length];

            // Input answers for each user
            for(int i=0;i<correctAnswers.length;i++){
                System.out.print("Q"+(i+1)+": ");
                studentAnswers[i]=sc.next().trim();
            }

            try{
                int score=calculateScore(correctAnswers,studentAnswers); // calculate score
                userScores.add(score); // store score
                double percentage=(score*100.0)/correctAnswers.length;
                String grade=getGrade(percentage);
                System.out.println("Score: "+score+"/"+correctAnswers.length);
                System.out.println("Percentage: "+String.format("%.2f",percentage)+"%");
                System.out.println("Grade: "+grade);
            }catch(InvalidQuizSubmissionException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        sc.close();
    }
}
