import java.util.Scanner;
public class LineComparisonProblem {
	
	// Use Case 1: model a line based on a point consisting of (x, y) co-ordinates using the Cartesian system.
	public static double calculateLength(double x1,double y1,double x2,double y2) {
		double length=Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
		return length;
	}
	
	// Use Case 2: check equality of two lines based on the end points (equal or not)
	public static boolean checkEqual(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4) {
		double length1=Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
		double length2=Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3,2));
		return length1==length2;
	}
	
	// User Case 3: check equality of two lines based on the end points (equal,less, and greater)
	public static int compareTo(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4) {
		double length1=Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
		double length2=Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3,2));
		if(length1==length2) return 0;
		else if(length1<length2) return -1;
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Line Comparison Computation Program");
		Scanner sc=new Scanner(System.in);
		
		// User input for 1st line
		System.out.print("Enter a x-axis of point1: ");
		double x1=sc.nextDouble();
		System.out.print("Enter a y-axis of point1: ");
		double y1=sc.nextDouble();
		System.out.print("Enter a x-axis of point2: ");
		double x2=sc.nextDouble();
		System.out.print("Enter a y-axis of point2: ");
		double y2=sc.nextDouble();
		
		double length1=calculateLength(x1,y1,x2,y2);
		
		// User input for 2nd line
		System.out.print("Enter a x-axis of point3: ");
		double x3=sc.nextDouble();
		System.out.print("Enter a y-axis of point3: ");
		double y3=sc.nextDouble();
		System.out.print("Enter a x-axis of point4: ");
		double x4=sc.nextDouble();
		System.out.print("Enter a y-axis of point4: ");
		double y4=sc.nextDouble();
		
		double length2=calculateLength(x3,y3,x4,y4);
		
		System.out.println("Length of line 1 is: "+length1);
		System.out.println("Length of line 2 is: "+length2);
		
		boolean equalAns=checkEqual(x1,y1,x2,y2,x3,y3,x4,y4);
		if(equalAns==true) System.out.println("After check length, the result is both length are equal");
		else System.out.println("After check length, the result is both length are not equal or different");
		
		int compareAns=compareTo(x1,y1,x2,y2,x3,y3,x4,y4);
		if(compareAns==0) System.out.println("After comparing length, the result is both length are equal");
		else if(compareAns==-1) System.out.println("After comparing length, the result is length1 "+length1+" is less than length2 "+length2);
		else System.out.println("After comparing length, the result is length1 "+length1+" is greater than length2 "+length2);
		
		sc.close();
	}
}