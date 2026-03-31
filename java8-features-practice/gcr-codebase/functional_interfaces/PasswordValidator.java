interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*");
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Abc123!@";
        System.out.println("Password strong: " + SecurityUtils.isStrongPassword(password));
    }
}
