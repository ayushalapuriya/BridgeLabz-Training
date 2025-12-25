import java.util.*;
public class EuclideanDistance {

    // Method to find the Euclidean distance between two points
    public static double findDistance(double x1,double y1,double x2,double y2) {
        double distance=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        return distance;
    }

    // Method to find the equation of a line given two points
    public static double[] findLineEquation(double x1,double y1,double x2,double y2) {
        double m=(y2-y1)/(x2-x1);
        double b=y1-m*x1;
        return new double[]{m,b};
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.println("Enter coordinates for 2 points:");
        System.out.print("Enter x1: ");
        double x1=sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1=sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2=sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2=sc.nextDouble();

        // Calculate Euclidean distance
        double distance=findDistance(x1,y1,x2,y2);
        System.out.println("\nEuclidean Distance: "+distance);

        // Calculate equation of line
        double[] equation=findLineEquation(x1,y1,x2,y2);
        double slope=equation[0];
        double yIntercept=equation[1];
        System.out.println("Equation of Line: y = "+slope+"x + "+yIntercept);
        System.out.println("Slope (m): "+slope);
        System.out.println("Y-intercept (b): "+yIntercept);

        sc.close();
    }
}
