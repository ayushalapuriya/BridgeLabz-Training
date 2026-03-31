import java.util.Scanner;
import java.util.Random;
public class NumGuessing {
	
	// Generate random guess
	public static int generateGuess(int low,int high) {
		Random ran=new Random();
		return ran.nextInt(high-low+1)+low;
	}
	
	// Get user feedback
	public static String getUserFeedback(Scanner sc,int guess) {
		System.out.println("Computer guessed: "+guess);
		System.out.print("Enter feedback (h-high, l-low, c-correct): ");
		return sc.next();
	}
	
	// Determine next guess range
	public static void playGame(Scanner sc) {
		int low=1;
		int high=100;
		int attempts=0;
		
		System.out.println("Think of a number between 1 and 100!");
		System.out.println("Computer will try to guess it.");
		
		// Game loop
		while(true) {
			attempts++;
			int guess=generateGuess(low,high);
			String feedback=getUserFeedback(sc,guess);
			
			// Check feedback
			if(feedback.equals("c")) {
				System.out.println("Computer guessed your number in "+attempts+" attempts!");
				break;
			}
			else if(feedback.equals("h")) {
				high=guess-1;
			}
			else if(feedback.equals("l")) {
				low=guess+1;
			}
			else {
				System.out.println("Invalid input! Use h, l or c");
				attempts--;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		// Play game
		playGame(sc);
		
		sc.close();
	}
}
