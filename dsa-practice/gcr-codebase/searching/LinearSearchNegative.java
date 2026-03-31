public class LinearSearchNegative {
    public static int firstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -2, 8, -7};
        int index = firstNegative(arr);
        System.out.println("First negative number index: " + index);
    }
}
