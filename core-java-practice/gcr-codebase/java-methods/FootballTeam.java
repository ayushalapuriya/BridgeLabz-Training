import java.util.*;
public class FootballTeam {

    // Method to find the sum of all elements in the array
    public static int findSum(int[] heights) {
        int sum=0;
        for(int i=0;i<heights.length;i++) {
            sum=sum+heights[i];
        }
        return sum;
    }

    // Method to find the mean height of the players
    public static double findMean(int[] heights) {
        int sum=findSum(heights);
        double mean=(double)sum/heights.length;
        return mean;
    }

    // Method to find the shortest height of the players
    public static int findShortest(int[] heights) {
        int shortest=heights[0];
        for(int i=1;i<heights.length;i++) {
            if(heights[i]<shortest) shortest=heights[i];
        }
        return shortest;
    }

    // Method to find the tallest height of the players
    public static int findTallest(int[] heights) {
        int tallest=heights[0];
        for(int i=1;i<heights.length;i++) {
            if(heights[i]>tallest) tallest=heights[i];
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights=new int[11];

        // Generate random heights between 150 and 250 cms for each player
        System.out.println("Heights of Football Team Players (in cms):");
        for(int i=0;i<heights.length;i++) {
            heights[i]=(int)(Math.random()*101)+150;
            System.out.println("Player "+(i+1)+": "+heights[i]+" cms");
        }

        int sum=findSum(heights);
        double mean=findMean(heights);
        int shortest=findShortest(heights);
        int tallest=findTallest(heights);

        // Display output
        System.out.println("\nSum of all heights: "+sum+" cms");
        System.out.println("Mean height: "+mean+" cms");
        System.out.println("Shortest player: "+shortest+" cms");
        System.out.println("Tallest player: "+tallest+" cms");
    }
}
