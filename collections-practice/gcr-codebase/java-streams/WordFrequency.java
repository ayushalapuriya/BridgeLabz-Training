import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        map.entrySet().stream()
           .sorted((a, b) -> b.getValue() - a.getValue())
           .limit(5)
           .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
