import java.util.Scanner;
import java.util.LinkedHashSet;

public class Lexial {

    public static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    public static boolean isReverse(String w1, String w2) {
        String rev = new StringBuilder(w1).reverse().toString();
        return rev.equalsIgnoreCase(w2);
    }

    public static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        // Case 1: second word is reverse of first
        if (isReverse(first, second)) {

            String reversed = new StringBuilder(first).reverse().toString().toLowerCase();
            StringBuilder result = new StringBuilder();

            for (char ch : reversed.toCharArray()) {
                if ("aeiou".indexOf(ch) != -1) {
                    result.append('@');
                } else {
                    result.append(ch);
                }
            }

            System.out.println(result.toString());
        }
        // Case 2: not reverse
        else {
            String combined = (first + second).toUpperCase();

            int vowelCount = 0, consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch))
                        vowelCount++;
                    else
                        consonantCount++;
                }
            }

            if (vowelCount > consonantCount) {
                LinkedHashSet<Character> vowels = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch)) {
                        vowels.add(ch);
                        if (vowels.size() == 2)
                            break;
                    }
                }
                for (char c : vowels)
                    System.out.print(c);
            } 
            else if (consonantCount > vowelCount) {
                LinkedHashSet<Character> consonants = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (Character.isLetter(ch) && !isVowel(ch)) {
                        consonants.add(ch);
                        if (consonants.size() == 2)
                            break;
                    }
                }
                for (char c : consonants)
                    System.out.print(c);
            } 
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }
}
