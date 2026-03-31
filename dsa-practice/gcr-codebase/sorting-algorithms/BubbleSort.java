import java.util.Scanner;

public class BubbleSort {
	public static void bubbleSort(int n, int[]arr) {
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		
		int[]arr = new int[n];
		System.out.print("Enter elements: ");
		for(int i =0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		bubbleSort(n,arr);
		
		for(int num: arr) System.out.print(num+ " ");
		
		sc.close();
	}
}
