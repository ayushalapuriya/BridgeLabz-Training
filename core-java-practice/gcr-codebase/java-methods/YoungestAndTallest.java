import java.util.*;
public class YoungestAndTallest {

    // Method to find youngest among 3
    public static int findYoungest(int[] ages) {
        int minAge=ages[0];
        int youngestIndex=0;
        for(int i=1;i<ages.length;i++) {
            if(ages[i]<minAge) {
                minAge=ages[i];
                youngestIndex=i;
            }
        }
        return youngestIndex;
    }

    // method to find tallest among 3
    public static int findTallest(double[] heights) {
        double maxHeight=heights[0];
        int tallestIndex=0;
        for(int i=1;i<heights.length;i++) {
            if(heights[i]>maxHeight) {
                maxHeight=heights[i];
                tallestIndex=i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names={"Amar","Akbar","Anthony"};
        int[] ages=new int[3];
        double[] heights=new double[3];

        // User input
        System.out.println("Enter details for 3 friends:");
        for(int i=0;i<3;i++) {
            System.out.print("Enter age of "+names[i]+": ");
            ages[i]=sc.nextInt();
            System.out.print("Enter height of "+names[i]+" (in cm): ");
            heights[i]=sc.nextDouble();
        }

        int youngestIndex=findYoungest(ages);
        int tallestIndex=findTallest(heights);

        // Display output
        System.out.println("Youngest friend is "+names[youngestIndex]+" with age "+ages[youngestIndex]);
        System.out.println("Tallest friend is "+names[tallestIndex]+" with height "+heights[tallestIndex]+" cm");
        sc.close();
    }
}
