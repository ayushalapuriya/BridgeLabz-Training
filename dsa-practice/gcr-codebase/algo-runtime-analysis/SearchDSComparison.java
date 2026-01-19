import java.util.*;

public class SearchDSComparison {

    public static void main(String[] args) {

        int n = 1_000_000;
        int target = n - 1;

        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start = System.currentTimeMillis();
        for (int x : arr) if (x == target) break;
        System.out.println("Array Search: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        hashSet.contains(target);
        System.out.println("HashSet Search: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        treeSet.contains(target);
        System.out.println("TreeSet Search: " + (System.currentTimeMillis() - start) + " ms");
    }
}
