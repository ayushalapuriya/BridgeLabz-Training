import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter the number of visitors in the queue: ");
        int totalVisitors = sc.nextInt();

        // Loop for each visitor and display output
        for(int i=1;i<=totalVisitors;i++) {
            System.out.println("\n--- Visitor " + i + " ---");
            System.out.print("Draw a lucky number: ");
            int number=sc.nextInt();
            if(number<=0) {
                System.out.println("Invalid number! Ticket cannot be zero or negative.");
                continue;
            }
            if(number%3==0 && number%5==0) System.out.println("🎉 Congratulations! You win a gift!");
            else System.out.println("Hard luck! Try again next time.");
        }
        System.out.println("\nLucky Draw Ended. Happy Diwali!");
        sc.close();
    }
}