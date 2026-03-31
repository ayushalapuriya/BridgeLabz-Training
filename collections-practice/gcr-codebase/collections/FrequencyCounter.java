import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : input) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Frequency of each word:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println("Word: '" + entry.getKey() + "' → Count: " + entry.getValue());
        }
        
        sc.close();
    }
}
