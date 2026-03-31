import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        Map<Integer,Integer> accounts = new HashMap<>();
        accounts.put(101,5000);
        accounts.put(102,8000);

        TreeMap<Integer,Integer> sorted = new TreeMap<>(accounts);
        System.out.println(sorted);
    }
}
