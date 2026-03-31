import java.util.Arrays;

public class SearchChallenge {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static int binarySearchIndex(int[] arr, int target) {
        Arrays.sort(arr); // binary search needs sorted array
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(nums));

        int[] arr = {5, 2, 8, 3};
        int target = 3;
        System.out.println("Target index after sorting: " + binarySearchIndex(arr, target));
    }
}
