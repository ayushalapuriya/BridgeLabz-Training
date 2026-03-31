import java.util.Scanner;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int min = 10;
        int max = 18;

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            count[arr[i] - min]++;

        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        countingSort(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }

}
