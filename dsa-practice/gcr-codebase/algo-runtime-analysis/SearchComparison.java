import java.util.Arrays;

public class SearchComparison {

    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log N)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1_000_000};
        int target = -1; // worst case (element not present)

        for (int size : sizes) {

            // Create dataset
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i;
            }

            // -------- Linear Search --------
            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();

            // -------- Binary Search --------
            Arrays.sort(data); // O(N log N)
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
