package util;

public class InputValidator {

    public static boolean validateCompanyName(String name){

        String regex = "^[A-Z][a-zA-Z]{2,}$";

        return name.matches(regex);
    }
}
