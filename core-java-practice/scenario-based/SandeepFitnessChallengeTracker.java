import java.util.Scanner;
public class SandeepFitnessChallengeTracker {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] pushUpsPerDay=new int[7];
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		// User input for each day
		System.out.println("Enter push-up counts for the week (Enter 0 for rest days):\n");		
		for(int i=0;i<7;i++) {
			System.out.print(days[i]+": ");
			pushUpsPerDay[i]=sc.nextInt();
		}
		int totalPushUps=0,activeDays=0;
		
		System.out.println("Sandeep's Fitness Challenge Tracker\n");
		System.out.println("Weekly Push-ups Report:");
		
		// Use for-each loop to calculate total and average
		int dayIndex=0;
		for(int pushUps:pushUpsPerDay) {
			if(pushUps==0) {
				System.out.println(days[dayIndex]+": Rest Day (skipped)");
				dayIndex++;
				continue;
			}
			System.out.println(days[dayIndex]+": "+pushUps+" push-ups");
			totalPushUps+=pushUps;
			activeDays++;
			dayIndex++;
		}
		
		// Calculate and display average
		double average=(activeDays>0)?(double)totalPushUps/activeDays:0;
		
		System.out.println("\nSummary:");
		System.out.println("Total Push-ups: "+totalPushUps);
		System.out.println("Active Days: "+activeDays+" out of 7");
		System.out.println("Average Push-ups per Active Day: "+average);
		System.out.println("\nGreat work, Sandeep! Keep it up!");
		
		sc.close();
	}
}
