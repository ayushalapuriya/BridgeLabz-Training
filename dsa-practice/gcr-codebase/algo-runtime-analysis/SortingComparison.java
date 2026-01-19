import java.util.Arrays;

public class SortingComparison {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = n - i;

        int[] a1 = data.clone();
        int[] a2 = data.clone();
        int[] a3 = data.clone();

        long start = System.currentTimeMillis();
        bubbleSort(a1);
        System.out.println("Bubble Sort: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        mergeSort(a2, 0, a2.length - 1);
        System.out.println("Merge Sort: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(a3);
        System.out.println("Quick Sort: " + (System.currentTimeMillis() - start) + " ms");
    }
}
