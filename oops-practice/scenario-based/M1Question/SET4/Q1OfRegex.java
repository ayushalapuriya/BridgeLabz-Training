package M1Question.SET4;

import java.util.*;
import java.util.regex.*;

public class Q1OfRegex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        while (n-- > 0) {
            String line = sc.nextLine();
            System.out.println(processLine(line));
        }

        sc.close();
    }

    static String processLine(String input) {

        // 1️⃣ DATE
        Pattern datePattern = Pattern.compile(
                "\\$\\{DATE:\\s(0[1-9]|[12][0-9]|3[01])\\s(0[1-9]|1[0-2])\\s(20\\d{2})\\}"
        );

        Matcher m = datePattern.matcher(input);
        while (m.find()) {
            String formatted = m.group(1) + "/" +
                    m.group(2) + "/" +
                    m.group(3);
            input = m.replaceFirst(formatted);
            m = datePattern.matcher(input);
        }

        // 2️⃣ UPPER
        Pattern upperPattern = Pattern.compile("\\$\\{UPPER:\\s([^}]+)\\}");
        m = upperPattern.matcher(input);
        while (m.find()) {
            input = m.replaceFirst(m.group(1).toUpperCase());
            m = upperPattern.matcher(input);
        }

        // 3️⃣ LOWER
        Pattern lowerPattern = Pattern.compile("\\$\\{LOWER:\\s([^}]+)\\}");
        m = lowerPattern.matcher(input);
        while (m.find()) {
            input = m.replaceFirst(m.group(1).toLowerCase());
            m = lowerPattern.matcher(input);
        }

        // 4️⃣ REPEAT
        Pattern repeatPattern = Pattern.compile("\\$\\{REPEAT:\\s([^\\s]+)\\s(\\d+)\\}");
        m = repeatPattern.matcher(input);
        while (m.find()) {
            String word = m.group(1);
            int count = Integer.parseInt(m.group(2));
            input = m.replaceFirst(word.repeat(count));
            m = repeatPattern.matcher(input);
        }

        return input;
    }
}