import java.util.*;
public class CalculateTrigonometricFunc {
	
	// Method to calculate trigonometric functions
	public static double[] calculateTrigonometricFunctions(double angle) {
		double[]ans=new double[3];
		double radians = Math.toRadians(angle);
        ans[0]=Math.sin(radians); // sine
        ans[1]=Math.cos(radians); // cosine
        ans[2]=Math.tan(radians); // tangent
        return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter angle in degrees: ");
        double angle=sc.nextDouble();

        double[] result=calculateTrigonometricFunctions(angle);

        // Display output
        System.out.println("Sine: " +result[0]);
        System.out.println("Cosine: " +result[1]);
        System.out.println("Tangent: " +result[2]);
        
		sc.close();
	}
}
