import java.util.*;
public class QuadraticEqRoots {

    // Method to find roots of quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        double bSquare=b*b;
        double fourAC=4*a*c;
        double delta=bSquare-fourAC;
        System.out.println("Delta value: "+delta);
        if(delta>0) {
            System.out.println("Delta is positive, so two roots exist");
            double sqrtDelta=Math.sqrt(delta);
            double root1=(-b+sqrtDelta)/(2*a);
            double root2=(-b-sqrtDelta)/(2*a);
            return new double[]{root1,root2};
        } else if(delta==0) {
            System.out.println("Delta is zero, so one root exists");
            double root=-b/(2*a);
            return new double[]{root};
        } else {
            System.out.println("Delta is negative, so no real roots exist");
            return new double[]{};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.println("Quadratic Equation: ax^2 + bx + c = 0");
        System.out.print("Enter value of a: ");
        double a=sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b=sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c=sc.nextDouble();

        double[] roots=findRoots(a,b,c);

        // Display output
        if(roots.length==2) {
            System.out.println("\nRoot 1: "+roots[0]);
            System.out.println("Root 2: "+roots[1]);
        } else if(roots.length==1) {
            System.out.println("\nRoot: "+roots[0]);
        }

        sc.close();
    }
}
