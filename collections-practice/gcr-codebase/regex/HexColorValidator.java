
public class HexColorValidator {

    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9a-fA-F]{6}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
    }
}
