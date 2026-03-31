import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String,Integer> votes = new HashMap<>();
        votes.put("A",3);
        votes.put("B",5);

        TreeMap<String,Integer> sorted = new TreeMap<>(votes);
        System.out.println(sorted);
    }
}
