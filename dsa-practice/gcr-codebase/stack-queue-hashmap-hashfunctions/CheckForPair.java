import java.util.HashSet;

public class CheckForPair {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int needed = target - num;
            if (set.contains(needed)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 3};
        int target = 8;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists with sum " + target);
        } else {
            System.out.println("No pair exists with sum " + target);
        }
    }
}
