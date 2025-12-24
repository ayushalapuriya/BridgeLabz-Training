import java.util.*;
public class ElectionBoothManager {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to poolling booth system");
		
		int candidate1Votes=0,candidate2Votes=0,candidate3Votes=0;
		
		while(true) {
			System.out.println("Enter your age: ");
			int age=sc.nextInt();
			
			if(age<=0) {
				System.out.println("Booth system exit because you enter special code");
				break;
			}
			else if(age<18) System.out.println("Sorry, we can't proceed because your age is less than 18");
			else {
				System.out.println("Select 1 for Candidate1, 2 for Candidate2, and 3 for Candidate3");
				int chooseCandidate=sc.nextInt();
				if(chooseCandidate==1) candidate1Votes++;
				else if(chooseCandidate==2) candidate2Votes++;
				else if(chooseCandidate==3) candidate3Votes++;
				else System.out.println("Invalid choose, vote not count");
			}
		}
		
		// Display votes count of each candidate
		System.out.println("Total number of votes of candidate 1 is: "+candidate1Votes);
		System.out.println("Total number of votes of candidate 2 is: "+candidate2Votes);
		System.out.println("Total number of votes of candidate 3 is: "+candidate3Votes);
		
		// Find who will this election
		if(candidate1Votes>candidate2Votes && candidate1Votes>candidate3Votes) 
			System.out.println("Candidate 1 have highest votes, so winner is candidate 1");
		else if(candidate2Votes>candidate1Votes && candidate2Votes>candidate3Votes)
			System.out.println("Candidate 2 have highest votes, so winner is candidate 2");
		else if(candidate3Votes>candidate1Votes && candidate3Votes>candidate2Votes)
			System.out.println("Candidate 3 have highest votes, so winner is candidate 3");
		else
			System.out.println("Election is tie because all candidates have equal votes");
		
		sc.close();
	}
}
