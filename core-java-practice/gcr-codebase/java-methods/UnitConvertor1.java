import java.util.*;
public class UnitConvertor1 {
    
    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet=3;
        return yards*yards2feet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards=0.333333;
        return feet*feet2yards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches=39.3701;
        return meters*meters2inches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters=0.0254;
        return inches*inches2meters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm=2.54;
        return inches*inches2cm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Unit Convertor =====");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        System.out.print("Enter your choice (1-5): ");

        int choice=sc.nextInt();
        double value,result;

        // User input and display output
        switch(choice) {
            case 1:
                System.out.print("Enter yards: ");
                value=sc.nextDouble();
                result=convertYardsToFeet(value);
                System.out.println(value+" yards= "+result+" feet");
                break;
            case 2:
                System.out.print("Enter feet: ");
                value=sc.nextDouble();
                result=convertFeetToYards(value);
                System.out.println(value+" feet= "+result+" yards");
                break;
            case 3:
                System.out.print("Enter meters: ");
                value=sc.nextDouble();
                result=convertMetersToInches(value);
                System.out.println(value+" meters= "+result+" inches");
                break;
            case 4:
                System.out.print("Enter inches: ");
                value=sc.nextDouble();
                result=convertInchesToMeters(value);
                System.out.println(value+" inches= "+result+" meters");
                break;
            case 5:
                System.out.print("Enter inches: ");
                value=sc.nextDouble();
                result=convertInchesToCentimeters(value);
                System.out.println(value+" inches= "+result+" cm");
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
