import java.util.*;
public class CanVoteWithRandomAge {
	
	// Method to generate random 2-digit ages
    public static int[] generateAges(int n) {
        int[]ages=new int[n];
        Random r=new Random();

        for(int i=0;i<n;i++) {
            ages[i]=r.nextInt(90) + 10; // 10 to 99
        }
        return ages;
    }
    
    // Student can vote or not
    public static String[][] canVote(int[]ages){
    	String[][]ageVote=new String[ages.length][2];
    	for(int i=0;i<ages.length;i++) {
    		ageVote[i][0]=String.valueOf(ages[i]);
    		if(ages[i]>=18) ageVote[i][1]="true";
    		else ageVote[i][1]="false";
    	}
    	return ageVote;
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input number
		int n=sc.nextInt();
		
		// generated age array
		int[]ages=generateAges(n);
		
		String[][]result=canVote(ages);
		
		// Display result
        System.out.println("Age\tCan Vote");
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
	}
}
