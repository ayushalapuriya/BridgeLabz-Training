// Custom exception for invalid scores
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message){
        super(message);
    }
}

public class StudentScoreAnalyzer {

    // Method to calculate average score
    public static double calculateAverage(int[] scores) throws InvalidScoreException {
        int sum=0;
        for(int score:scores){
            validateScore(score);
            sum+=score;
        }
        return (double)sum/scores.length;
    }

    // Method to find highest score
    public static int findMax(int[] scores) throws InvalidScoreException {
        int max=scores[0];
        for(int score:scores){
            validateScore(score);
            if(score>max) max=score;
        }
        return max;
    }

    // Method to find lowest score
    public static int findMin(int[] scores) throws InvalidScoreException {
        int min=scores[0];
        for(int score:scores){
            validateScore(score);
            if(score<min) min=score;
        }
        return min;
    }

    // Method to validate score
    private static void validateScore(int score) throws InvalidScoreException {
        if(score<0 || score>100)
            throw new InvalidScoreException("Invalid score found: "+score);
    }

    // Main method to test the program
    public static void main(String[] args){
        int[] scores={78,85,92,66,88};

        try{
            System.out.println("Average Score: "+calculateAverage(scores));
            System.out.println("Highest Score: "+findMax(scores));
            System.out.println("Lowest Score: "+findMin(scores));
        }
        catch(InvalidScoreException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
