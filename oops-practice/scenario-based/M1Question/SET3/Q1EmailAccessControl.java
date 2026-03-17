package M1Question.SET3;

import java.util.*;

public class Q1EmailAccessControl {

    static Set<String> departments = new HashSet<>(
            Arrays.asList("sales", "marketing", "IT", "product")
    );

    static boolean validateEmail(String email) {

        if (email.contains(" "))
            return false;

        String regex =
                "^([a-z]{3,})\\.([a-z]{3,})(\\d{4,})@([A-Za-z]+)\\.company\\.com$";

        if (!email.matches(regex))
            return false;

        String dept = email.split("@")[1].split("\\.")[0];

        return departments.contains(dept);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String email = sc.nextLine();

            if (validateEmail(email))
                System.out.println("Access Granted");
            else
                System.out.println("Access Denied");
        }
    }
}