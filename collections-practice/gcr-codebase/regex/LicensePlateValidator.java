
public class LicensePlateValidator {

    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234"));
        System.out.println(isValidLicensePlate("A12345"));
    }
}
