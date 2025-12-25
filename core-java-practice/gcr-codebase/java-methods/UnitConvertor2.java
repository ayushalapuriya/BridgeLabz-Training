import java.util.*;
public class UnitConvertor2 {

    // Method to convert fahrenheit to celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius=(fahrenheit-32)*5/9;
        return fahrenheit2celsius;
    }

    // Method to convert celsius to fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit=(celsius*9/5)+32;
        return celsius2fahrenheit;
    }

    // Method to convert pounds to kg
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms=0.453592;
        return pounds*pounds2kilograms;
    }

    // Method to convert kg to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds=2.20462;
        return kilograms*kilograms2pounds;
    }

    // Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters=3.78541;
        return gallons*gallons2liters;
    }

    // Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons=0.264172;
        return liters*liters2gallons;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Unit Convertor =====");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        System.out.print("Enter your choice (1-6): ");

        int choice=sc.nextInt();
        double value,result;
        
        switch(choice) {
            case 1:
                System.out.print("Enter Fahrenheit: ");
                value=sc.nextDouble();
                result=convertFahrenheitToCelsius(value);
                System.out.println(value+" F= "+result+" C");
                break;
            case 2:
                System.out.print("Enter Celsius: ");
                value=sc.nextDouble();
                result=convertCelsiusToFahrenheit(value);
                System.out.println(value+" C= "+result+" F");
                break;
            case 3:
                System.out.print("Enter pounds: ");
                value=sc.nextDouble();
                result=convertPoundsToKilograms(value);
                System.out.println(value+" lbs= "+result+" kg");
                break;
            case 4:
                System.out.print("Enter kilograms: ");
                value=sc.nextDouble();
                result=convertKilogramsToPounds(value);
                System.out.println(value+" kg= "+result+" lbs");
                break;
            case 5:
                System.out.print("Enter gallons: ");
                value=sc.nextDouble();
                result=convertGallonsToLiters(value);
                System.out.println(value+" gallons= "+result+" liters");
                break;
            case 6:
                System.out.print("Enter liters: ");
                value=sc.nextDouble();
                result=convertLitersToGallons(value);
                System.out.println(value+" liters= "+result+" gallons");
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
