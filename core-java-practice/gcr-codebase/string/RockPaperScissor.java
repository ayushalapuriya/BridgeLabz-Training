import java.util.*;
public class RockPaperScissor {
	
	// computer choice 
	public static String getComputerChoice(){
		int random=(int)(Math.random()*3);
		if(random==0) return "rock";
		else if(random==1) return "paper";
	    else return "scissors";
	}
	
	// find winner
	public static String determineWinner(String user, String comp){
		if(user.equals(comp)) return "Tie";
		if((user.equals("rock") && comp.equals("scissors")) || 
		   (user.equals("paper") && comp.equals("rock")) || 
		   (user.equals("scissors") && comp.equals("paper"))) return "User";
        else return "Computer";
	}
	
	// stats calculation
	public static String[][] calculateStats(int userWins, int compWins, int ties, int total){
		String[][] stats=new String[4][3];
		stats[0][0]="Player";
		stats[0][1]="Wins";
		stats[0][2]="Win %";
		
		stats[1][0]="User";
		stats[1][1]=String.valueOf(userWins);
		stats[1][2]=String.format("%.2f%%",(userWins*100.0)/total);
		
		stats[2][0]="Computer";
		stats[2][1]=String.valueOf(compWins);
		stats[2][2]=String.format("%.2f%%",(compWins*100.0)/total);
		
		stats[3][0]="Ties";
		stats[3][1]=String.valueOf(ties);
		stats[3][2]=String.format("%.2f%%",(ties*100.0)/total);
		
		return stats;
	}
	
	// display results
	public static void displayResults(String[][] games, String[][] stats){
		System.out.println();
		System.out.println("GAME RESULTS");
		System.out.println("Game No.\t User Choice \t Computer Choice \t Winner");
		for(int i=1;i<games.length;i++){
			System.out.println(games[i][0]+" \t "+games[i][1]+" \t "+games[i][2]+" \t "+games[i][3]);
		}
		
		System.out.println();
		System.out.println("STATISTICS");
		System.out.println(stats[0][0]+" \t "+stats[0][1]+" \t "+stats[0][2]);
		for(int i=1;i<stats.length;i++){
			System.out.println(stats[i][0]+" \t "+stats[i][1]+" \t "+stats[i][2]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Input 
		System.out.print("Enter number of games: ");
		int n=sc.nextInt();
		sc.nextLine();
		
		int userWins=0, compWins=0, ties=0;
		String[][] games=new String[n+1][4];
		
		for(int i=1;i<=n;i++){
			System.out.print("Enter choice (rock/paper/scissors): ");
			String user=sc.nextLine().toLowerCase().trim();
			
			while(!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")){
				System.out.print("Invalid! Enter rock/paper/scissors: ");
				user=sc.nextLine().toLowerCase().trim();
			}
			
			String comp=getComputerChoice();
			
			String winner=determineWinner(user,comp);
			
			if(winner.equals("User")) userWins++;
			else if(winner.equals("Computer")) compWins++;
			else ties++;
			
			games[i][0]=String.valueOf(i);
			games[i][1]=user;
			games[i][2]=comp;
			games[i][3]=winner;
		}
		
		String[][] stats=calculateStats(userWins,compWins,ties,n);
		displayResults(games,stats);
		
		sc.close();
	}
}
