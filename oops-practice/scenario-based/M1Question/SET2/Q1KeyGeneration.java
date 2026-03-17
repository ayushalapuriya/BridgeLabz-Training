package M1Question.SET2;

import java.util.*;

public class Q1KeyGeneration {

    static String generateKey(String s) {

        if (s == null || s.length() == 0)
            return "Invalid Input (empty string)";

        if (s.length() < 6)
            return "Invalid Input (length < 6)";

        if (s.contains(" "))
            return "Invalid Input (contains space)";

        if (s.matches(".*\\d.*"))
            return "Invalid Input (contains digits)";

        if (!s.matches("[a-zA-Z]+"))
            return "Invalid Input (contains special character)";

        s = s.toLowerCase();

        StringBuilder filtered = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ((int) c % 2 != 0)
                filtered.append(c);
        }

        filtered.reverse();

        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0)
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
        }

        return "The generated key is - " + filtered;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();
            System.out.println(generateKey(s));
        }
    }
}