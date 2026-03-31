interface SensitiveData {}

class UserCredentials implements SensitiveData {
    String username;
    String password;
    UserCredentials(String u, String p) { username = u; password = p; }
}

public class SensitiveTest {
    public static void main(String[] args) {
        UserCredentials creds = new UserCredentials("admin", "12345");
        System.out.println("Is sensitive: " + (creds instanceof SensitiveData));
    }
}
