import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is fun and Java is powerful";
        String[] words = paragraph.split(" ");

        Map<String, Long> wordCount = Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(wordCount);
    }
}
