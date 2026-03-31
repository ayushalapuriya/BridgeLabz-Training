import java.util.*;
public class UnitConvertor {

    // Method to convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles=0.621371;
        return km*km2miles;
    }

    // Method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km=1.60934;
        return miles*miles2km;
    }

    // Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet=3.28084;
        return meters*meters2feet;
    }

    // Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters=0.3048;
        return feet*feet2meters;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("===== Unit Converter =====");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.print("Enter your choice (1-4): ");
        
        int choice=sc.nextInt();
        double value,result;
        
        switch(choice) {
            case 1:
                System.out.print("Enter kilometers: ");
                value=sc.nextDouble();
                result=convertKmToMiles(value);
                System.out.println(value+" km= "+result+" miles");
                break;
            case 2:
                System.out.print("Enter miles: ");
                value=sc.nextDouble();
                result=convertMilesToKm(value);
                System.out.println(value+" miles= "+result+" km");
                break;
            case 3:
                System.out.print("Enter meters: ");
                value=sc.nextDouble();
                result=convertMetersToFeet(value);
                System.out.println(value+" meters= "+result+" feet");
                break;
            case 4:
                System.out.print("Enter feet: ");
                value=sc.nextDouble();
                result=convertFeetToMeters(value);
                System.out.println(value+" feet= "+result+" meters");
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
}
