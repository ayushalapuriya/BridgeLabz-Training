import java.util.*;
public class Collinear {

    // Method to find if 3 points are collinear using the slope formula
    public static boolean areCollinearBySlope(int x1,int y1,int x2,int y2,int x3,int y3) {
        double slopeAB=(double)(y2-y1)/(x2-x1);
        double slopeBC=(double)(y3-y2)/(x3-x2);
        double slopeAC=(double)(y3-y1)/(x3-x1);
        return slopeAB==slopeBC && slopeBC==slopeAC;
    }

    // Method to find if 3 points are collinear using area of triangle formula
    public static boolean areCollinearByArea(int x1,int y1,int x2,int y2,int x3,int y3) {
        double area=0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return area==0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.println("Enter coordinates for 3 points:");
        System.out.print("Enter x1: ");
        int x1=sc.nextInt();
        System.out.print("Enter y1: ");
        int y1=sc.nextInt();
        System.out.print("Enter x2: ");
        int x2=sc.nextInt();
        System.out.print("Enter y2: ");
        int y2=sc.nextInt();
        System.out.print("Enter x3: ");
        int x3=sc.nextInt();
        System.out.print("Enter y3: ");
        int y3=sc.nextInt();

        // Check collinearity using slope formula
        boolean collinearBySlope=areCollinearBySlope(x1,y1,x2,y2,x3,y3);
        System.out.println("\nUsing Slope Formula:");
        if(collinearBySlope) System.out.println("Points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") are Collinear");
        else System.out.println("Points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") are not Collinear");

        // Check collinearity using area of triangle formula
        boolean collinearByArea=areCollinearByArea(x1,y1,x2,y2,x3,y3);
        System.out.println("\nUsing Area of Triangle Formula:");
        if(collinearByArea) System.out.println("Points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") are Collinear");
        else System.out.println("Points A("+x1+","+y1+"), B("+x2+","+y2+"), C("+x3+","+y3+") are not Collinear");

        sc.close();
    }
}
