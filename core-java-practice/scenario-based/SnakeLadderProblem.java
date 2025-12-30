import java.util.Scanner;
public class SnakeLadderProblem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter 1 for Single Player, 2 for Two Players: ");
		int mode=sc.nextInt();
		
		if(mode==1) {
			// UC 1: Single player starts at position 0
			int position=0;
			int diceCount=0;
			
			System.out.println("Starting position: " + position);
			
			// UC 4: Repeat till player reaches position 100
			while(position!=100) {
				// UC 2: Roll die to get number 1 to 6
				int die=(int)(Math.random()*6)+1;
				diceCount++;
				
				// UC 3: Check for option (0-No Play, 1-Ladder, 2-Snake)
				int option=(int)(Math.random()*3);
				int prevPosition=position;

				if(option==0) position+=0;
				else if(option==1) position+=die;
				else if(option==2) position-=die;
				
				// UC 4: If position < 0, restart from 0
				if(position<0) position=0;
				
				// UC 5: Ensure exact winning position 100
				if(position>100) position=prevPosition;
				
				// UC 6: Report position after every die roll
				System.out.println("Roll "+diceCount+" | Die: "+die+" | Option: "+option+" | Position: "+prevPosition+" -> "+position);
			}
			
			// UC 6: Report total dice rolls to win
			System.out.println("\nGame Won! Total dice rolls: "+diceCount);
		}
		else if(mode==2) {
			// UC 7: Two Player Game
			int pos1=0,pos2=0;
			int count1=0,count2=0;
			int currentPlayer=1;
			
			System.out.println("Player 1 and Player 2 start at position 0");
			
			while(pos1!=100 && pos2!=100) {
				int die=(int)(Math.random()*6)+1;
				int option=(int)(Math.random()*3);
				
				if(currentPlayer==1) {
					count1++;
					int prev=pos1;
					if(option==0) pos1+=0;
					else if(option==1) pos1+=die;
					else if(option==2) pos1-=die;
					
					if(pos1<0) pos1=0;
					if(pos1>100) pos1=prev;
					
					System.out.println("Player 1 | Roll " + count1 + " | Die: " + die + " | Option: " + option + " | Position: " + prev + " -> " + pos1);
					
					// UC 7: If ladder, play again
					if(option!=1) currentPlayer=2;
				}
				else {
					count2++;
					int prev = pos2;
					if(option==0) pos2+=0;
					else if(option==1) pos2+=die;
					else if(option==2) pos2 -= die;
					
					if(pos2<0) pos2=0;
					if(pos2>100) pos2=prev;
					
					System.out.println("Player 2 | Roll "+count2+" | Die: "+die+" | Option: "+option+" | Position: "+prev+" -> "+pos2);
					
					// UC 7: If ladder, play again
					if(option!=1) currentPlayer=1;
				}
			}
			
			// UC 7: Report which player won
			if(pos1==100) System.out.println("\nPlayer 1 Won! Total rolls: "+count1);
			else System.out.println("\nPlayer 2 Won! Total rolls: "+count2);
		}
		
		sc.close();
	}
}
