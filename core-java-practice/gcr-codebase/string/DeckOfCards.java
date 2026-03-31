import java.util.*;
public class DeckOfCards {
	
	// Method to initialize deck
	public static String[] initializeDeck(String[]suits,String[]ranks) {
		int numOfCards=suits.length*ranks.length;
		String[]deck=new String[numOfCards];
		int idx=0;
		
		for(int i=0;i<suits.length;i++) {
			for(int j=0;j<ranks.length;j++) {
				deck[idx]=ranks[j]+" of "+suits[i];
				idx++;
			}
		}
		return deck;
	}
	
	// Method to shuffle deck
	public static String[] shuffleDeck(String[]deck) {
		int n=deck.length;
		
		for(int i=0;i<n;i++) {
			int randomCardNumber=i+(int)(Math.random()*(n-i));
			String temp=deck[i];
			deck[i]=deck[randomCardNumber];
			deck[randomCardNumber]=temp;
		}
		return deck;
	}
	
	// Method to distribute cards to players
	public static String[][] distributeCards(String[]deck,int numCards,int numPlayers) {
		if(numCards*numPlayers>deck.length) return null;
		
		String[][]players=new String[numPlayers][numCards];
		int idx=0;
		
		for(int i=0;i<numPlayers;i++) {
			for(int j=0;j<numCards;j++) {
				players[i][j]=deck[idx];
				idx++;
			}
		}
		return players;
	}
	
	// Method to print players cards
	public static void printPlayers(String[][]players) {
		for(int i=0;i<players.length;i++) {
			System.out.print("Player "+(i+1)+": ");
			for(int j=0;j<players[i].length;j++) {
				System.out.print(players[i][j]);
				if(j<players[i].length-1) System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String[]suits={"Hearts","Diamonds","Clubs","Spades"};
		String[]ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		// Initialize deck
		String[]deck=initializeDeck(suits,ranks);
		
		// Shuffle deck
		deck=shuffleDeck(deck);
		
		// Input number of cards and players
		System.out.print("Enter number of cards per player: ");
		int numCards=sc.nextInt();
		System.out.print("Enter number of players: ");
		int numPlayers=sc.nextInt();
		
		// Distribute cards
		String[][]players=distributeCards(deck,numCards,numPlayers);
		
		if(players!=null) printPlayers(players);
		else System.out.println("Not enough cards to distribute");
		
		sc.close();
	}
}