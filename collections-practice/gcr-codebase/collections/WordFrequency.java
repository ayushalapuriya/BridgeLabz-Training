import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();

        System.out.println("Enter text:");
        String[] words = sc.nextLine().toLowerCase().replaceAll("[^a-z ]","").split(" ");

        for(String w:words)
            map.put(w,map.getOrDefault(w,0)+1);

        System.out.println(map);
    }
}
